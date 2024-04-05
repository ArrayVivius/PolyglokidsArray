package com.polyglokids.com.configurations.handlerErrors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

// @ControllerAdvice
// public class GlobalExceptionHandler {
//
// @ExceptionHandler(ResponseStatusException.class)
// public ResponseEntity<String>
// handleResponseStatusException(ResponseStatusException ex) {
// return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
// }
//
// // add other handler error here it's necesary
// }
