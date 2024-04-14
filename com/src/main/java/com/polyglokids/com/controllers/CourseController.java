package com.polyglokids.com.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.polyglokids.com.configurations.handlerErrors.DTOValidationService;
import com.polyglokids.com.domain.entities.types.course.CourseDTO;
import com.polyglokids.com.persistence.models.course.CourseModel;
import com.polyglokids.com.usecases.CreateCouserUseCase;
import com.polyglokids.com.usecases.GetCourseUseCase;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/course")
public class CourseController {

  private final CreateCouserUseCase createCourseUseCase;

  private final GetCourseUseCase getCourseUseCase;

  private final DTOValidationService dtoValidationService;

  @Autowired
  public CourseController(CreateCouserUseCase createCouserUseCase, DTOValidationService dtoValidationService,
      GetCourseUseCase getCourseUseCase) {
    this.createCourseUseCase = createCouserUseCase;
    this.getCourseUseCase = getCourseUseCase;
    this.dtoValidationService = dtoValidationService;
    // this.signInUseCase = signInUseCase;
  }

  @PostMapping("/create")
  public ResponseEntity createUser(@Valid @RequestBody CourseDTO bod, BindingResult bindingResult) {
    ResponseEntity<?> validationResponse = dtoValidationService.validateDTO(bod, bindingResult);
    if (validationResponse != null) {
      return validationResponse;
    }
    try {
      System.out.println("hello");
      CourseModel course = createCourseUseCase.save(bod);
      return ResponseEntity.ok(course);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al tratar de guardar los registros", e);
    }

  }

  @GetMapping("/{id}")
  public ResponseEntity findCourseWithLessons(@PathVariable String id) {
    try {
      Optional<CourseModel> course = getCourseUseCase.GetCourseByIdWithAllLesson(id);
      return ResponseEntity.ok(course);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al tratar de Obtener el registro", e);
    }

  }
}
