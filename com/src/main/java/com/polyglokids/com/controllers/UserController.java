package com.polyglokids.com.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.polyglokids.com.domain.entities.UserEntity;
import com.polyglokids.com.domain.entities.types.user.UserDTO;
import com.polyglokids.com.persistence.models.course.CourseModel;
import com.polyglokids.com.persistence.models.user.UserModel;
import com.polyglokids.com.usecases.CreateUserUseCase;
import com.polyglokids.com.usecases.GetUserCouesesUseCase;
import com.polyglokids.com.usecases.GetUserCourseByStatusUseCase;
import com.polyglokids.com.usecases.SignInUseCase;

import jakarta.validation.Valid;

@RestController
@Validated
public class UserController {

  private final CreateUserUseCase createUserUseCase;

  private final SignInUseCase signInUseCase;
  private final GetUserCouesesUseCase getUserCoursesUseCase;
  private final GetUserCourseByStatusUseCase getUserCoursesBySatatusUseCase;

  @Autowired
  public UserController(CreateUserUseCase createUserUseCase, SignInUseCase signInUseCase,
      GetUserCouesesUseCase getUserCoursesUseCase, GetUserCourseByStatusUseCase getUserCoursesBySatatusUseCase) {
    this.createUserUseCase = createUserUseCase;
    this.signInUseCase = signInUseCase;
    this.getUserCoursesUseCase = getUserCoursesUseCase;
    this.getUserCoursesBySatatusUseCase = getUserCoursesBySatatusUseCase;

  }

  @PostMapping("user")
  public UserModel createUser(@Valid @RequestBody UserDTO bod) {
    System.out.println("test new new");
    System.out.println(bod);
    UserModel user = createUserUseCase.save(bod);
    return user;
  }

  @GetMapping("/UserCourse/{id}")
  public ResponseEntity GetUserCourse(@PathVariable String id) {
    try {
      List<CourseModel> course = getUserCoursesUseCase.getCursosByUserId(id);
      return ResponseEntity.ok(course);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al tratar de Obtener el registro", e);
    }

  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/UserCourseByStatus/{id}")
  public ResponseEntity GetUserCourseByStatus(@PathVariable String id) {
    try {
      Map<String, List<CourseModel>> course = getUserCoursesBySatatusUseCase.getCoursesByUserId(id);
      return ResponseEntity.ok(course);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al tratar de Obtener el registro", e);
    }

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
