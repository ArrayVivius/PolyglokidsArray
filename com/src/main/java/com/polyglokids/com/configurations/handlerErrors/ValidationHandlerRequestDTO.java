package com.polyglokids.com.configurations.handlerErrors;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * ValidationHandlerRequestDTO
 */
@Service
public class ValidationHandlerRequestDTO implements DTOValidationService {

  @Override
  public <T> ResponseEntity<?> validateDTO(T dto, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      Map<String, String> errors = new HashMap<>();
      for (FieldError error : bindingResult.getFieldErrors()) {
        errors.put(error.getField(), error.getDefaultMessage());
      }
      return ResponseEntity.badRequest().body(errors);
    }
    return null;
  }
}
