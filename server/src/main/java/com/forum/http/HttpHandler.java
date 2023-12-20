package com.forum.http;

public interface HttpHandler {
  public void handle(HttpRequest request, HttpResponse response);
}
