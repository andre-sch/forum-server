package com.forum.features.authenticateUser;

import com.forum.http.*;
import com.forum.providers.*;
import com.forum.providers.impl.*;

class AuthenticateUserController implements HttpEndpointHandler {
  private AuthenticateUserService service;
  private JSONProvider JSON = new JSONProviderGoogleAdapter();

  public AuthenticateUserController(AuthenticateUserService service) {
    this.service = service;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    var authRequest = this.JSON.deserialize(request.getBody(), UserAuthenticationRequest.class);

    String token = this.service.execute(authRequest);
    TokenView tokenView = new TokenView(token);

    response.json(tokenView);
  }
}
