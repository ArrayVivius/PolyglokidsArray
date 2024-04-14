package com.polyglokids.com.usecases.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.polyglokids.com.persistence.models.user.UserDao;
import com.polyglokids.com.persistence.models.user.UserModel;

import jakarta.transaction.Transactional;

/**
 * FindUserById
 */
@Component
public class FindUserByEmailService implements UserDetailsService {

  @Autowired
  private UserDao userDao;

  @Transactional
  public UserModel loadUserByUsername(String username) throws UsernameNotFoundException {
    UserModel user = userDao.findByCorreo(username)
        .orElseThrow(
            () -> new UsernameNotFoundException("Usuario no encontrado con el correo electrónico: " + username));
    user.getRoles().size();
    return user;
  }
}
