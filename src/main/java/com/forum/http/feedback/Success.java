package com.forum.http.feedback;

public class Success extends HttpFeedback {
  public Success(String message) {
    this.code = 200;
    this.status = "ok";
    this.message = message;
  }
}
