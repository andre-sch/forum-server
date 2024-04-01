package com.forum.features.createAdmin;

import com.forum.http.*;
import com.forum.entities.User;
import com.forum.views.CompleteUserView;
import com.forum.providers.*;
import com.forum.providers.impl.*;
import com.forum.features.createUser.*;

class CreateAdminController implements HttpEndpointHandler {
  private final String[] roleNames = { "admin", "member" };
  private final String[] addedPermissionNames = {};

  private CreateUserService createUserService;
  private JSONProvider JSON = new JSONProviderGoogleAdapter();

  public CreateAdminController(CreateUserService service) {
    this.createUserService = service;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    RequestBody requestBody = this.JSON.deserialize(request.getBody(), RequestBody.class);

    UserCreationRequest creationRequest = new UserCreationRequest();

    creationRequest.name = requestBody.name;
    creationRequest.email = requestBody.email;
    creationRequest.password = requestBody.password;
    creationRequest.roleNames = this.roleNames;
    creationRequest.addedPermissionNames = this.addedPermissionNames;

    User createdUser = this.createUserService.execute(creationRequest);
    CompleteUserView createdUserView = new CompleteUserView(createdUser);

    response.status(201);
    response.json(createdUserView);
  };

  private class RequestBody {
    public String name;
    public String email;
    public String password;
  }
}
