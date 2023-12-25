package com.forum.features.listUsers;

import com.forum.http.HttpHandler;
import com.forum.repositories.UsersRepository;

public class ListUsers {
  public ListUsers(UsersRepository usersRepository) {
    ListUsersService service = new ListUsersService(usersRepository);
    ListUsersController controller = new ListUsersController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
