package com.forum.features.listUsers;

import com.forum.http.HttpHandler;
import com.forum.repositories.UsersRepository;

public class ListUsers {
  private UsersRepository usersRepository;
  private ListUsersService listUsersService;
  private ListUsersController listUsersController;

  public ListUsers(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
    this.listUsersService = new ListUsersService(this.usersRepository);
    this.listUsersController = new ListUsersController(this.listUsersService);
    
    this.handler = this.listUsersController;
  }

  public HttpHandler handler;
}
