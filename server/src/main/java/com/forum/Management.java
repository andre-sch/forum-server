package com.forum;

import com.forum.repositories.*;
import com.forum.features.createUser.*;
import com.forum.providers.*;
import com.forum.providers.impl.*;

public class Management {
  // must be replaced by external config on production
  private final String name = "root";
  private final String email = "root@admin";
  private final String password = "root";

  private final String[] roleNames = { "admin", "member" };
  private final String[] addedPermissionNames = {};

  private CreateUserService service;

  private UsersRepository usersRepository = Repositories.getUsersRepository();
  private RolesRepository rolesRepository = Repositories.getRolesRepository();
  private PermissionsRepository permissionsRepository = Repositories.getPermissionsRepository();

  private HashProvider hashProvider = new HashProviderBCryptAdapter();

  public Management() {
    this.service = new CreateUserService(hashProvider, usersRepository, rolesRepository, permissionsRepository);
  }

  public void insertSystemAdmin() {
    boolean adminAlreadyExists = this.usersRepository.listOneByEmail(email) != null;
    if (adminAlreadyExists) return;

    var creationRequest = new UserCreationRequest();

    creationRequest.name = this.name;
    creationRequest.email = this.email;
    creationRequest.password = this.password;
    creationRequest.roleNames = this.roleNames;
    creationRequest.addedPermissionNames = this.addedPermissionNames;

    this.service.execute(creationRequest);
  }
}
