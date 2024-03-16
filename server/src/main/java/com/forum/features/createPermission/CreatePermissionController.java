package com.forum.features.createPermission;

import com.forum.http.*;
import com.forum.entities.Permission;
import com.forum.views.CompletePermissionView;
import com.forum.providers.*;
import com.forum.providers.impl.*;

class CreatePermissionController implements HttpEndpointHandler {
  private CreatePermissionService createPermissionService;
  private JSONProvider JSON = new JSONProviderGoogleAdapter();

  public CreatePermissionController(CreatePermissionService service) {
    this.createPermissionService = service;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    var creationRequest = this.JSON.deserialize(request.getBody(), PermissionCreationRequest.class);

    Permission createdPermission = this.createPermissionService.execute(creationRequest);
    CompletePermissionView createdPermissionView = new CompletePermissionView(createdPermission);

    response.status(201);
    response.json(createdPermissionView);
  }
}
