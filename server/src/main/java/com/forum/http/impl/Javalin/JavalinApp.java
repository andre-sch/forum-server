package com.forum.http.impl.Javalin;

import com.forum.http.*;
import io.javalin.Javalin;

public class JavalinApp implements HttpApp {
  private Javalin app;

  public JavalinApp(Javalin app) {
    this.app = app;
  }

  public void get(String path, HttpEndpointHandler handler) {
    this.app.get(path, EndpointHandlerWrapper.wrap(handler));
  }

  public void post(String path, HttpEndpointHandler handler) {
    this.app.post(path, EndpointHandlerWrapper.wrap(handler));
  }

  public void put(String path, HttpEndpointHandler handler) {
    this.app.put(path, EndpointHandlerWrapper.wrap(handler));
  }

  public void delete(String path, HttpEndpointHandler handler) {
    this.app.delete(path, EndpointHandlerWrapper.wrap(handler));
  }

  public void exception(HttpExceptionHandler handler) {
    this.app.exception(Exception.class, ExceptionHandlerWrapper.wrap(handler));
  }
}
