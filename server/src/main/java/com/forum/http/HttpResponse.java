package com.forum.http;

public interface HttpResponse {
  public void status(int code);
  public void json(Object content);
}
