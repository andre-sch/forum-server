package com.forum.features.updateUser;

import com.forum.http.HttpEndpointHandler;
import com.forum.repositories.UsersRepository;
import com.forum.providers.*;
import com.forum.providers.impl.*;

public class UpdateUser {
  private HashProvider hashProvider = new HashProviderBCryptAdapter();

  public UpdateUser(UsersRepository usersRepository) {
    UpdateUserService service = new UpdateUserService(this.hashProvider, usersRepository);
    UpdateUserController controller = new UpdateUserController(service);

    this.handler = controller;
  }

  public HttpEndpointHandler handler;
}
