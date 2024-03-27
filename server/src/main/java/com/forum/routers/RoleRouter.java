package com.forum.routers;

import com.forum.*;
import com.forum.http.*;
import com.forum.endpoints.*;
import com.forum.repositories.*;

import com.forum.features.listRoles.*;
import com.forum.features.createRole.*;
import com.forum.features.deleteRole.*;

public class RoleRouter implements Router {
  private HttpApp app;
  private RestrictedEndpointFactory restrictedEndpoint = new RestrictedEndpointFactory();

  private RolesRepository rolesRepository = Repositories.getRolesRepository();
  private PermissionsRepository permissionsRepository = Repositories.getPermissionsRepository();

  public RoleRouter(HttpApp app) {
    this.app = app;
  }

  public void bindEndpoints() {
    app.get("/roles", restrictedEndpoint.create(
      new ListRoles(rolesRepository).handler,
      "list-roles"
    ));

    app.post("/roles", restrictedEndpoint.create(
      new CreateRole(rolesRepository, permissionsRepository).handler,
      "create-role"
    ));

    app.delete("/roles/{roleName}", restrictedEndpoint.create(
      new DeleteRole(rolesRepository).handler,
      "delete-role"
    ));
  }
}
