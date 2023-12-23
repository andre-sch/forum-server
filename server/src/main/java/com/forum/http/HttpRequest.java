package com.forum.http;

public interface HttpRequest {
  public String body();
  public String getParam(String name);
}
