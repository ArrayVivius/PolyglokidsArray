package com.polyglokids.com.usecases.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import com.polyglokids.com.persistence.models.user.UserDao;
import com.polyglokids.com.persistence.models.user.UserModel;
import com.polyglokids.com.persistence.models.user.UsersDao;

import jakarta.transaction.Transactional;

@Component
public class FindUserByIdService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private UsersDao usersDao;

  public UserModel loadUserById(String username) throws UsernameNotFoundException {
    UserModel user = (UserModel) userDao.findById(username)
        .orElseThrow(
            () -> new UsernameNotFoundException("Usuario no encontrado con el correo electrónico: " + username));

    user.getRoles();
    return user;
  }

  @Transactional
  public List<UserModel> findUsersByIds(Set<String> userIds) {
    // Obtener la lista de usuarios por sus IDs
    List<UserModel> users = usersDao.findAllById(userIds);
    // Asegurarse de que se hayan encontrado todos los usuarios
    return users;
  }
}
