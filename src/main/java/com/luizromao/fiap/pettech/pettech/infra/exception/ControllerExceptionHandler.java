package com.luizromao.fiap.pettech.pettech.infra.exception;

import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ControllerExceptionHandler {

  private final StandardError error = new StandardError();

  @ExceptionHandler(ControllerNotFoundException.class)
  public ResponseEntity<StandardError> entityNotFoundException(
      ControllerNotFoundException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    error.setTimeStamp(Instant.now());
    error.setStatus(status.value());
    error.setError("Entity not found");
    error.setMessage(e.getMessage());

    return ResponseEntity.status(status).body(this.error);
  }
}
