package com.polyglokids.com.usecases;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.polyglokids.com.DTOs.auth.AuthRes;
import com.polyglokids.com.configurations.security.JWTUtils;
import com.polyglokids.com.usecases.service.FindUserByEmailService;

/**
 * SignInUseCase
 */
@Service
public class SignInUseCase {

  @Autowired
  private FindUserByEmailService findUserByEmailService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JWTUtils jwUtils;

  public AuthRes singIn(String email, String password) {
    try {
      AuthRes res = new AuthRes();
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
      UserDetails user = findUserByEmailService.loadUserByUsername(email);
      System.out.println("USER IS" + user);
      var jwt = jwUtils.generateToken(user);
      var refreshToken = jwUtils.generateRefreshToken(new HashMap<>(), user);
      System.out.println("JWT" + jwt);
      res.setToken(jwt);
      res.setRefreshToken(refreshToken);
      return res;
    } catch (Exception e) {
      System.out.println("e " + e);
      return null;
    }

  }
}
