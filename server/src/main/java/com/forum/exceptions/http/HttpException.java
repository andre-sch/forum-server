package com.forum.exceptions.http;

import com.forum.http.HttpFeedback;

public class HttpException extends HttpFeedback {
  public HttpException(String message) {
    super(message);
  }
}
