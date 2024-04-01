package com.forum.exceptions.http;

public class BadRequest extends HttpException {
  public BadRequest(String message) {
    super(message);
    super.code = 400;
    super.status = "bad request";
  }
}
