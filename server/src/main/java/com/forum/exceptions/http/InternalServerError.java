package com.forum.exceptions.http;

public class InternalServerError extends HttpException {
  public InternalServerError(String message) {
    super(message);
    super.code = 500;
    super.status = "internal server error";
  }
}
