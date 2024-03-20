package com.ramasquare.backend.exception;

import lombok.Getter;

@Getter
public class BadCredentialsException extends RuntimeException {
  private String errorCode;

  public BadCredentialsException(String message, String errorCode) {
    super(message);
    this.errorCode = errorCode;
  }
}
