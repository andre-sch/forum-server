package com.forum.features.createMember;

import com.forum.http.*;
import com.forum.entities.User;
import com.forum.views.CompleteUserView;
import com.forum.providers.*;
import com.forum.providers.impl.*;
import com.forum.features.createUser.*;

class CreateMemberController implements HttpEndpointHandler {
  private final String[] roleNames = { "member" };
  private final String[] addedPermissionNames = {};

  private CreateUserService createUserService;
  private JSONProvider JSON = new JSONProviderGoogleAdapter();

  public CreateMemberController(CreateUserService service) {
    this.createUserService = service;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    RequestBody requestBody = this.JSON.deserialize(request.getBody(), RequestBody.class);

    UserCreationRequest creationRequest = new UserCreationRequest();

    creationRequest.name = requestBody.name;
    creationRequest.email = requestBody.email;
    creationRequest.password = requestBody.password;
    creationRequest.avatarUrl = requestBody.avatarUrl;
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
    public String avatarUrl;
  }
}
