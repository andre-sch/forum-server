package com.forum.http;

public interface HttpApp {
  public void get(String path, HttpHandler handler);
  public void post(String path, HttpHandler handler);
  public void put(String path, HttpHandler handler);
  public void delete(String path, HttpHandler handler);
}
