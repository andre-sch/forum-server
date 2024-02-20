package com.forum.features.deleteUser;

import com.forum.http.*;

class DeleteUserController implements HttpEndpointHandler {
  private DeleteUserService deleteUserService;

  public DeleteUserController(DeleteUserService deleteUserService) {
    this.deleteUserService = deleteUserService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String userId = request.getPathParam("userId");

    this.deleteUserService.execute(userId);

    response.status(204);
  }
}
