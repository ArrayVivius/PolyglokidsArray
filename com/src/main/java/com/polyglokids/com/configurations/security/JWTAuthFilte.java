package com.polyglokids.com.configurations.security;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.polyglokids.com.persistence.models.role.ERoleType;
import com.polyglokids.com.persistence.models.user.UserModel;
import com.polyglokids.com.usecases.service.FindUserByEmailService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * JWTAuthFilte
 */
@Component
public class JWTAuthFilte extends OncePerRequestFilter {

  @Autowired
  private JWTUtils jwtUtils;

  @Autowired
  private FindUserByEmailService findUserByEmailService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    final String authHeader = request.getHeader("Authorization");
    final String jwtToken;
    final String userEmail;
    if (authHeader == null || authHeader.isBlank()) {
      filterChain.doFilter(request, response);
      return;
    }
    jwtToken = authHeader.substring(7);
    userEmail = jwtUtils.extractUsername(jwtToken);
    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserModel userDetails = findUserByEmailService.loadUserByUsername(userEmail);

      if (jwtUtils.isTokenValid(jwtToken, userDetails)) {

        Set<ERoleType> rolesFromUser = userDetails.getRoles();
        List<GrantedAuthority> authorities = rolesFromUser.stream()
            .map(role -> new SimpleGrantedAuthority(role.toString()))
            .collect(Collectors.toList());

        System.out.println("authorities " + authorities);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
            userDetails, null, authorities);
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        System.out.println("token " + token);

        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(token);
        SecurityContextHolder.setContext(securityContext);
      }
    }
    filterChain.doFilter(request, response);
  }
}
