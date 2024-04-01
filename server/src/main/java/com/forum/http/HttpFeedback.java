package com.forum.http;

public class HttpFeedback {
  public int code;
  public String status;
  public String message;

  public HttpFeedback(String message) {
    this.message = message;
  }
}
