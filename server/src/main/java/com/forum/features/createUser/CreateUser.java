package com.forum.features.createUser;

import com.forum.security.HashProvider;
import com.forum.security.HashProviderBCryptAdapter;
import com.forum.http.HttpEndpointHandler;
import com.forum.repositories.UsersRepository;

public class CreateUser {
  private HashProvider hashProvider = new HashProviderBCryptAdapter();

  public CreateUser(UsersRepository usersRepository) {
    CreateUserService service = new CreateUserService(this.hashProvider, usersRepository);
    CreateUserController controller = new CreateUserController(service);

    this.handler = controller;
  }

  public HttpEndpointHandler handler;
}
