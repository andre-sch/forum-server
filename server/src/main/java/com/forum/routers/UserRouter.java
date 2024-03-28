package com.forum.routers;

import com.forum.*;
import com.forum.http.*;
import com.forum.endpoints.*;
import com.forum.repositories.*;

import com.forum.features.listUsers.*;
import com.forum.features.createMember.*;
import com.forum.features.createAdmin.*;
import com.forum.features.authenticateUser.*;
import com.forum.features.updateUser.*;
import com.forum.features.deleteUser.*;

public class UserRouter implements Router {
  private HttpApp app;
  private RestrictedEndpointFactory restrictedEndpoint = new RestrictedEndpointFactory();

  private UsersRepository usersRepository = Repositories.getUsersRepository();
  private RolesRepository rolesRepository = Repositories.getRolesRepository();
  private PermissionsRepository permissionsRepository = Repositories.getPermissionsRepository();

  public UserRouter(HttpApp app) {
    this.app = app;
  }

  public void bindEndpoints() {
    app.get("/users", restrictedEndpoint.create(
      new ListUsers(usersRepository).handler,
      "list-users"
    ));

    app.post("/members", new CreateMember(usersRepository, rolesRepository, permissionsRepository).handler);
    app.post("/admins",  restrictedEndpoint.create(
      new CreateAdmin(usersRepository, rolesRepository, permissionsRepository).handler,
      "create-admin"
    ));

    app.post("/login", new AuthenticateUser(usersRepository).handler);

    app.put("/users/{userId}", restrictedEndpoint.create(
      new UpdateUser(usersRepository).handler,
      "update-user"
    ));

    app.delete("/users/{userId}", restrictedEndpoint.create(
      new DeleteUser(usersRepository).handler,
      "delete-user"
    ));
  }
}
