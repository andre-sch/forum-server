package com.forum.features.listUsers;

import java.util.List;
import com.forum.http.*;

class ListUsersController implements HttpHandler {
  private ListUsersService listUsersService;

  public ListUsersController(ListUsersService listUsersService) {
    this.listUsersService = listUsersService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    List<UserView> users = this.listUsersService.execute();
    response.json(users);
  };
}
