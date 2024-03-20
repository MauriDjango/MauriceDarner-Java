package com.example.exception;

public class BeerNotFoundException extends RuntimeException {

  public BeerNotFoundException() {
    super();
  }

  public BeerNotFoundException(String message) {
    super(message);
  }

  public BeerNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public BeerNotFoundException(Throwable cause) {
    super(cause);
  }
}
