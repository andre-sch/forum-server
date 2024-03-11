package com.forum.features.deleteUser;

import com.forum.http.*;

class DeleteUserController implements HttpEndpointHandler {
  private DeleteUserService deleteUserService;

  public DeleteUserController(DeleteUserService deleteUserService) {
    this.deleteUserService = deleteUserService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String authenticatedUserId = (String) request.getSessionAttribute("userId");

    String deletedUserId = request.getPathParam("userId");

    UserDeletionRequest deletionRequest = new UserDeletionRequest();

    deletionRequest.authenticatedUserId = authenticatedUserId;
    deletionRequest.deletedUserId = deletedUserId;

    this.deleteUserService.execute(deletionRequest);

    response.status(204);
  }
}
