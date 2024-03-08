package com.forum.endpoints;

import com.forum.http.*;
import com.forum.exceptions.domain.*;
import com.forum.security.*;

public class AuthenticatedEndpoint implements HttpEndpointHandler {
  private HttpEndpointHandler endpoint;
  private JWTProvider jwtProvider = new JWTProviderAuth0Adapter();

  public AuthenticatedEndpoint(HttpEndpointHandler endpoint) {
    this.endpoint = endpoint;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String authorization = request.getHeader("authorization");

    if (authorization == null) {
      throw new InvalidTokenException("token missing");
    }

    String authorizationContent;

    try {
      authorizationContent = authorization.split(" ")[1];
    } catch(Exception exception) {
      throw new InvalidTokenException("invalid token");
    }

    ParsedToken token = this.jwtProvider.parse(authorizationContent);
    request.setSessionAttribute("userId", token.subject);

    endpoint.handle(request, response);
  }
}
