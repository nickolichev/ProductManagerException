package ru.netology;

public class NotFoundIdException extends RuntimeException {

  public NotFoundIdException(String s) {
    super(s);
  }
}