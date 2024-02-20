package com.forum.exceptions.domain;

public class ResourceException extends RuntimeException {
  public ResourceException() {
    super("requested resource is not available");
  }
}
