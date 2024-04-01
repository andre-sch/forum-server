package com.forum.routers;

import com.forum.*;
import com.forum.http.*;
import com.forum.endpoints.*;
import com.forum.repositories.*;

import com.forum.features.listPermissions.*;
import com.forum.features.createPermission.*;
import com.forum.features.deletePermission.*;

public class PermissionRouter implements Router {
  private HttpApp app;
  private RestrictedEndpointFactory restrictedEndpoint = new RestrictedEndpointFactory();
  private PermissionsRepository permissionsRepository = Repositories.getPermissionsRepository();

  public PermissionRouter(HttpApp app) {
    this.app = app;
  }

  public void bindEndpoints() {
    this.app.get("/permissions", restrictedEndpoint.create(
      new ListPermissions(permissionsRepository).handler,
      "list-permissions"
    ));

    this.app.post("/permissions", restrictedEndpoint.create(
      new CreatePermission(permissionsRepository).handler,
      "create-permission"
    ));

    this.app.delete("/permissions/{permissionName}", restrictedEndpoint.create(
      new DeletePermission(permissionsRepository).handler,
      "delete-permission"
    ));
  }
}
