package com.forum.exceptions.http;

public class NotFound extends HttpException {
  public NotFound(String message) {
    super(message);
    super.code = 404;
    super.status = "not found";
  }
}
