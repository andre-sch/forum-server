package com.forum.features.listUsers;

import com.forum.http.HttpHandler;
import com.forum.repositories.Repository;
import com.forum.entities.User;

public class ListUsers {
  public ListUsers(Repository<User> usersRepository) {
    ListUsersService service = new ListUsersService(usersRepository);
    ListUsersController controller = new ListUsersController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
