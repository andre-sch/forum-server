package com.forum.http;

public interface HttpApp {
  public void use(String path, HttpEndpointHandler handler);
  public void get(String path, HttpEndpointHandler handler);
  public void post(String path, HttpEndpointHandler handler);
  public void put(String path, HttpEndpointHandler handler);
  public void delete(String path, HttpEndpointHandler handler);
  public void exception(HttpExceptionHandler handler);
}
