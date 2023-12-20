package com.forum.http.impl.Javalin;

import com.forum.http.*;

import io.javalin.http.Handler;
import io.javalin.http.Context;

class JavalinHandler implements Handler {
  private HttpHandler handler;

  public JavalinHandler(HttpHandler handler) {
    this.handler = handler;
  }

  public void handle(Context httpContext) {
    HttpRequest request = new JavalinRequest(httpContext);
    HttpResponse response = new JavalinResponse(httpContext);
    this.handler.handle(request, response);
  }
}
