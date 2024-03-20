package com.example.exception;

public class BreweryNotFoundException extends RuntimeException {

  public BreweryNotFoundException() {
    super();
  }

  public BreweryNotFoundException(String message) {
    super(message);
  }

  public BreweryNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public BreweryNotFoundException(Throwable cause) {
    super(cause);
  }
}
