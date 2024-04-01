package com.forum.endpoints;

import com.forum.http.*;
import com.forum.http.feedback.Success;

public class ServerHealthCheck implements HttpEndpointHandler {
  public void handle(HttpRequest request, HttpResponse response) {
    response.json(new Success("server is running"));
  }
}
