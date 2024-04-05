package com.polyglokids.com.configurations.handlerErrors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface DTOValidationService {
  <T> ResponseEntity<?> validateDTO(T dto, BindingResult bindingResult);
}
