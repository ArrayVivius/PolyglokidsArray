// package com.polyglokids.com.configurations.handlerErrors;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.server.ResponseStatusException;
//
//
// /**
// * GlobalExceptionHandler
// */
//
//
// @ControllerAdvice
// public class GlobalExceptionHandler {
//
//
// @ExceptionHandler(ResponseStatusException.class)
// public ResponseEntity<Object>
// handleResponseStatusException(ResponseStatusException ex) {
// HttpStatus status = HttpStatus.valueOf(ex.getRawStatusCode());
// String message = ex.getReason();
// return ResponseEntity.status(status).body(message);
// }
// }
