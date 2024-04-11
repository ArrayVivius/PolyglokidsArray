
package com.polyglokids.com.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.polyglokids.com.DTOs.auth.AuthRes;
import com.polyglokids.com.configurations.handlerErrors.DTOValidationService;
import com.polyglokids.com.domain.entities.types.user.UserDTO;
import com.polyglokids.com.persistence.models.user.UserModel;
import com.polyglokids.com.usecases.CreateUserUseCase;
import com.polyglokids.com.usecases.SignInUseCase;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
  private final DTOValidationService dtoValidationService;

  private final CreateUserUseCase createUserUseCase;

  private final SignInUseCase signInUseCase;

  @Autowired
  public AuthController(CreateUserUseCase createUserUseCase, SignInUseCase signInUseCase,
      DTOValidationService dtoValidationService) {
    this.createUserUseCase = createUserUseCase;
    this.signInUseCase = signInUseCase;
    this.dtoValidationService = dtoValidationService;
  }

  @PostMapping("/signUp")
  public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO bod, BindingResult bindingResult) {
    ResponseEntity<?> validationResponse = dtoValidationService.validateDTO(bod, bindingResult);
    if (validationResponse != null) {
      return validationResponse;
    }

    try {
      UserModel user = createUserUseCase.save(bod);
      return ResponseEntity.ok(user);
    } catch (Exception e) {
      return new ResponseEntity("Error al tratar de guardar los registros", HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/signIn")
  public ResponseEntity<?> getUser(@RequestParam String correo, @RequestParam String contraseña) {
    AuthRes user = signInUseCase.singIn(correo, contraseña);
    if (user == null) {
      return new ResponseEntity("el ususario es invalido", HttpStatus.UNAUTHORIZED);
    }
    return ResponseEntity.ok(user);
  }
}
