package com.polyglokids.com.persistence.models.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserModel, String> {
  Optional<UserModel> findByCorreo(String username);
}
