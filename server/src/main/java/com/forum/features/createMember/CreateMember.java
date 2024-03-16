package com.forum.features.createMember;

import com.forum.http.*;
import com.forum.repositories.*;
import com.forum.security.*;
import com.forum.security.impl.*;
import com.forum.features.createUser.*;

public class CreateMember {
  private HashProvider hashProvider = new HashProviderBCryptAdapter();

  public CreateMember(
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

    CreateMemberController controller = new CreateMemberController(service);

    this.handler = controller;
  }

  public HttpEndpointHandler handler;
}
