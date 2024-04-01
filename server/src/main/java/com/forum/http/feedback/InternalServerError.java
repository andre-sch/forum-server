package com.forum.http.feedback;

public class InternalServerError extends HttpFeedback {
  public InternalServerError(String message) {
    this.code = 500;
    this.status = "internal server error";
    this.message = message;
  }
}
