package com.forum.features.deleteUser;

import com.forum.http.HttpEndpointHandler;
import com.forum.repositories.Repository;
import com.forum.entities.User;

public class DeleteUser {
  public DeleteUser(Repository<User> usersRepository) {
    DeleteUserService service = new DeleteUserService(usersRepository);
    DeleteUserController controller = new DeleteUserController(service);

    this.handler = controller;
  }

  public HttpEndpointHandler handler;
}
