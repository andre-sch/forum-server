package com.forum.features.deleteComment;

import java.util.*;
import com.forum.http.*;

class DeleteCommentController implements HttpEndpointHandler {
  private DeleteCommentService deleteCommentService;

  public DeleteCommentController(DeleteCommentService deleteCommentService) {
    this.deleteCommentService = deleteCommentService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    @SuppressWarnings("unchecked")
    Set<String> authenticatedUserRoles = (Set<String>) request.getSessionAttribute("userRoles");
    String authenticatedUserId = (String) request.getSessionAttribute("userId");

    String commentId = request.getPathParam("commentId");

    CommentDeletionRequest deletionRequest = new CommentDeletionRequest();

    deletionRequest.commentId = commentId;
    deletionRequest.authenticatedUserId = authenticatedUserId;
    deletionRequest.isAuthoritative = authenticatedUserRoles.contains("admin");

    this.deleteCommentService.execute(deletionRequest);

    response.status(204);
  }
}
