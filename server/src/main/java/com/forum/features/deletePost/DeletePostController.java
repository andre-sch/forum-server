package com.forum.features.deletePost;

import java.util.*;
import com.forum.http.*;

class DeletePostController implements HttpEndpointHandler {
  private DeletePostService deletePostService;

  public DeletePostController(DeletePostService deletePostService) {
    this.deletePostService = deletePostService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    @SuppressWarnings("unchecked")
    Set<String> authenticatedUserRoles = (Set<String>) request.getSessionAttribute("userRoles");
    String authenticatedUserId = (String) request.getSessionAttribute("userId");

    String postId = request.getPathParam("postId");

    PostDeletionRequest deletionRequest = new PostDeletionRequest();

    deletionRequest.postId = postId;
    deletionRequest.authenticatedUserId = authenticatedUserId;
    deletionRequest.isModerator = authenticatedUserRoles.contains("admin");

    this.deletePostService.execute(deletionRequest);

    response.status(204);
  }
}
