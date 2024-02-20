package com.forum.features.updateUser;

import com.forum.http.HttpEndpointHandler;
import com.forum.repositories.Repository;
import com.forum.entities.User;

public class UpdateUser {
  public UpdateUser(Repository<User> usersRepository) {
    UpdateUserService service = new UpdateUserService(usersRepository);
    UpdateUserController controller = new UpdateUserController(service);

    this.handler = controller;
  }

  public HttpEndpointHandler handler;
}
