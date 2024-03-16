package com.forum.features.createAdmin;

import com.forum.http.*;
import com.forum.repositories.*;
import com.forum.security.*;
import com.forum.security.impl.*;
import com.forum.features.createUser.*;

public class CreateAdmin {
  private HashProvider hashProvider = new HashProviderBCryptAdapter();

  public CreateAdmin(
    UsersRepository usersRepository,
    RolesRepository rolesRepository,
    PermissionsRepository permissionsRepository
  ) {
    CreateUserService service = new CreateUserService(
      this.hashProvider,
      usersRepository,
      rolesRepository,
      permissionsRepository
    );

    CreateAdminController controller = new CreateAdminController(service);

    this.handler = controller;
  }

  public HttpEndpointHandler handler;
}
