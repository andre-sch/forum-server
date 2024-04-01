package com.forum.features.deleteUser;

import java.util.*;
import com.forum.http.*;

class DeleteUserController implements HttpEndpointHandler {
  private DeleteUserService deleteUserService;

  public DeleteUserController(DeleteUserService deleteUserService) {
    this.deleteUserService = deleteUserService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    @SuppressWarnings("unchecked")
    Set<String> authenticatedUserPermissions = (Set<String>) request.getSessionAttribute("userPermissions");
    String authenticatedUserId = (String) request.getSessionAttribute("userId");

    String deletedUserId = request.getPathParam("userId");

    UserDeletionRequest deletionRequest = new UserDeletionRequest();

    deletionRequest.deletedUserId = deletedUserId;
    deletionRequest.authenticatedUserId = authenticatedUserId;
    deletionRequest.isAuthoritative = authenticatedUserPermissions.contains("moderate-contribution");

    this.deleteUserService.execute(deletionRequest);

    response.status(204);
  }
}
