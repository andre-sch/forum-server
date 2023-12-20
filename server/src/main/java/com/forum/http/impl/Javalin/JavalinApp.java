package com.forum.http.impl.Javalin;

import com.forum.http.HttpApp;
import com.forum.http.HttpHandler;

import io.javalin.Javalin;

public class JavalinApp implements HttpApp {
  private Javalin app;

  public JavalinApp(Javalin app) {
    this.app = app;
  }

  public void get(String path, HttpHandler handler) {
    this.app.get(path, new JavalinHandler(handler));
  }

  public void post(String path, HttpHandler handler) {
    this.app.post(path, new JavalinHandler(handler));
  }

  public void put(String path, HttpHandler handler) {
    this.app.put(path, new JavalinHandler(handler));
  }

  public void delete(String path, HttpHandler handler) {
    this.app.delete(path, new JavalinHandler(handler));
  }
}
