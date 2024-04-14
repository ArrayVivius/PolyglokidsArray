package com.polyglokids.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.polyglokids.com.domain.entities.UserEntity;
import com.polyglokids.com.domain.entities.types.user.UserDTO;
import com.polyglokids.com.persistence.models.user.UserModel;
import com.polyglokids.com.usecases.CreateUserUseCase;
import com.polyglokids.com.usecases.SignInUseCase;

import jakarta.validation.Valid;

@RestController
@Validated
public class UserController {

  private final CreateUserUseCase createUserUseCase;

  private final SignInUseCase signInUseCase;

  @Autowired
  public UserController(CreateUserUseCase createUserUseCase, SignInUseCase signInUseCase) {
    this.createUserUseCase = createUserUseCase;
    this.signInUseCase = signInUseCase;
  }

  @PostMapping("user")
  public UserModel createUser(@Valid @RequestBody UserDTO bod) {
    System.out.println("test new new");
    System.out.println(bod);
    UserModel user = createUserUseCase.save(bod);
    return user;
  }

  // @GetMapping("user")
  // public ResponseEntity findUser(@RequestParam String id){
  //
  // }

  // @GetMapping("user")
  // public UserDetails getUser(@PathVariable String correo) {
  // UserDetails user = signInUseCase.singIn(correo);
  // return user; }
}
