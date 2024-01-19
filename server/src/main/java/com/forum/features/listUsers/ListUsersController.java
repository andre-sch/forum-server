package com.forum.features.listUsers;

import java.util.List;
import com.forum.http.*;
import com.forum.entities.User;

class ListUsersController implements HttpHandler {
  private ListUsersService listUsersService;

  public ListUsersController(ListUsersService listUsersService) {
    this.listUsersService = listUsersService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    List<User> users = this.listUsersService.execute();
    List<UserView> userViews = users.stream().map(UserView::new).toList();

    response.json(userViews);
  };
}
