package com.forum.http.feedback;

public class NotFound extends HttpFeedback {
  public NotFound(String message) {
    this.code = 404;
    this.status = "not found";
    this.message = message;
  }
}
