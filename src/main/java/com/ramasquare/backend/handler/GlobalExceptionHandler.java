package com.ramasquare.backend.handler;

import com.ramasquare.backend.Dto.auth.ErrorResponse;
import com.ramasquare.backend.exception.BadCredentialsException;
import com.ramasquare.backend.exception.InvalidTokenException;
import com.ramasquare.backend.exception.UserAlreadyExistsException;
import com.ramasquare.backend.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
    return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body(
            ErrorResponse.builder()
                .errorCode(e.getErrorCode())
                .errorMessage(e.getMessage())
                .build()
        );
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(
            ErrorResponse.builder()
                .errorCode(e.getErrorCode())
                .errorMessage(e.getMessage())
                .build()
        );
  }

  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity<ErrorResponse> handleBadCredentialsException(BadCredentialsException e) {
    return ResponseEntity
        .status(HttpStatus.UNAUTHORIZED)
        .body(
            ErrorResponse.builder()
                .errorCode(e.getErrorCode())
                .errorMessage(e.getMessage())
                .build()
        );
  }

  @ExceptionHandler(InvalidTokenException.class)
  public ResponseEntity<ErrorResponse> handleInvalidTokenException(InvalidTokenException e) {
    return ResponseEntity
        .status(HttpStatus.UNAUTHORIZED)
        .body(
            ErrorResponse.builder()
                .errorCode(e.getErrorCode())
                .errorMessage(e.getMessage())
                .build()
        );
  }
}
