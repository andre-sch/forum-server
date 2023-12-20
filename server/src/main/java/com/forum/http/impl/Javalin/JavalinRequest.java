package com.forum.http.impl.Javalin;

import com.forum.http.HttpRequest;
import io.javalin.http.Context;

class JavalinRequest implements HttpRequest {
  private Context httpContext;

  public JavalinRequest(Context httpContext) {
    this.httpContext = httpContext;
  }

  public String body() {
    return this.httpContext.body();
  }
}
