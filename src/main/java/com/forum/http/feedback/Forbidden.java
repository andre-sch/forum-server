package com.forum.http.feedback;

public class Forbidden extends HttpFeedback {
  public Forbidden(String message) {
    this.code = 403;
    this.status = "forbidden";
    this.message = message;
  }
}

