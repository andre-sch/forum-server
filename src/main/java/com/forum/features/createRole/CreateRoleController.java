package com.forum.features.createRole;

import com.forum.http.*;
import com.forum.entities.Role;
import com.forum.views.CompleteRoleView;
import com.forum.providers.*;
import com.forum.providers.impl.*;

class CreateRoleController implements HttpEndpointHandler {
  private CreateRoleService createRoleService;
  private JSONProvider JSON = new JSONProviderGoogleAdapter();

  public CreateRoleController(CreateRoleService service) {
    this.createRoleService = service;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    RoleCreationRequest creationRequest = this.JSON.deserialize(request.getBody(), RoleCreationRequest.class);

    Role createdRole = this.createRoleService.execute(creationRequest);
    CompleteRoleView createdRoleView = new CompleteRoleView(createdRole);

    response.status(201);
    response.json(createdRoleView);
  }
}
