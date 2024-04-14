package com.polyglokids.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.polyglokids.com.configurations.handlerErrors.DTOValidationService;
import com.polyglokids.com.domain.entities.types.lesson.LessonDTO;
import com.polyglokids.com.persistence.models.lesson.LessonModel;
import com.polyglokids.com.usecases.CreateLessonUseCase;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/lesson")
public class LessonController {

  private final CreateLessonUseCase createLessonUseCase;
  private final DTOValidationService dtoValidationService;

  @Autowired
  public LessonController(CreateLessonUseCase createLessonUseCase, DTOValidationService dtoValidationService) {
    this.createLessonUseCase = createLessonUseCase;
    this.dtoValidationService = dtoValidationService;
  }

  @PostMapping("/createLesson")
  public ResponseEntity<?> createLesson(@Valid @RequestBody LessonDTO bod,
      BindingResult bindingResult) {
    ResponseEntity<?> validationResponse = dtoValidationService.validateDTO(bod,
        bindingResult);
    if (validationResponse != null) {
      return validationResponse;
    }
    try {
      LessonModel lesson = createLessonUseCase.save(bod);
      return ResponseEntity.ok(lesson);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "Error al tratar de guardar los registros de la lección", e);
    }
  }
}
