package com.forum.http.impl.Javalin;

import java.util.List;
import com.forum.http.HttpRequest;
import io.javalin.http.Context;

class JavalinRequest implements HttpRequest {
  private Context httpContext;

  public JavalinRequest(Context httpContext) {
    this.httpContext = httpContext;
  }

  public String getBody() {
    return this.httpContext.body();
  }

  public String getPathParam(String name) {
    return this.httpContext.pathParam(name);
  }

  public String getQueryParam(String name) {
    return this.httpContext.queryParam(name);
  }

  public List<String> getQueryParams(String name) {
    return this.httpContext.queryParams(name);
  }
}
