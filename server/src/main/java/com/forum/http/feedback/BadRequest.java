package com.forum.http.feedback;

public class BadRequest extends HttpFeedback {
  public BadRequest(String message) {
    this.code = 400;
    this.status = "bad request";
    this.message = message;
  }
}
