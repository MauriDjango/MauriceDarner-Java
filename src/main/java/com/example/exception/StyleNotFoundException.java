package com.example.exception;

public class StyleNotFoundException extends RuntimeException{

  public StyleNotFoundException() {
    super();
  }

  public StyleNotFoundException(String message) {
    super(message);
  }

  public StyleNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public StyleNotFoundException(Throwable cause) {
    super(cause);
  }
}
