package com.luizromao.fiap.pettech.pettech.infra.exception;

public class ControllerNotFoundException extends RuntimeException {

  public ControllerNotFoundException(final String message) {
    super(message);
  }
}
