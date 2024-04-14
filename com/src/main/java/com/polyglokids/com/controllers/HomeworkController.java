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
import com.polyglokids.com.domain.entities.types.homework.HomeWorkDTO;
import com.polyglokids.com.persistence.models.homework.HomeWorkModel;
import com.polyglokids.com.usecases.CreateHomeworkUseCase;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/homework")
public class HomeworkController {

  private final CreateHomeworkUseCase createHomeWorkUseCase;
  private final DTOValidationService dtoValidationService;

  @Autowired
  public HomeworkController(CreateHomeworkUseCase createHomeWorkUseCase, DTOValidationService dtoValidationService) {
    this.createHomeWorkUseCase = createHomeWorkUseCase;
    this.dtoValidationService = dtoValidationService;
  }

  @PostMapping("/createHomework")
  public ResponseEntity<?> createHomeWork(@Valid @RequestBody HomeWorkDTO bod, BindingResult bindingResult) {
    ResponseEntity<?> validationResponse = dtoValidationService.validateDTO(bod, bindingResult);
    if (validationResponse != null) {
      return validationResponse;
    }
    try {
      HomeWorkModel homework = createHomeWorkUseCase.save(bod);
      return ResponseEntity.ok(homework);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "Error al tratar de guardar los registros de la tarea", e);
    }
  }
}
