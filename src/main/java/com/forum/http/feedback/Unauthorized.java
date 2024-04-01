package com.forum.http.feedback;

public class Unauthorized extends HttpFeedback {
  public Unauthorized(String message) {
    this.code = 401;
    this.status = "unauthorized";
    this.message = message;
  }
}
