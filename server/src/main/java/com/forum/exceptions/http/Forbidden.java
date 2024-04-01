package com.forum.exceptions.http;

public class Forbidden extends HttpException {
  public Forbidden(String message) {
    super(message);
    super.code = 403;
    super.status = "forbidden";
  }
}

