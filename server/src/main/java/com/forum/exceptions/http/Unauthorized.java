package com.forum.exceptions.http;

public class Unauthorized extends HttpException {
  public Unauthorized(String message) {
    super(message);
    super.code = 401;
    super.status = "unauthorized";
  }
}
