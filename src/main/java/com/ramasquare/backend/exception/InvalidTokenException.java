package com.ramasquare.backend.exception;

import lombok.Getter;

@Getter
public class InvalidTokenException extends RuntimeException {
  private String errorCode;

  public InvalidTokenException(String message, String errorCode) {
    super(message);
    this.errorCode = errorCode;
  }
}
