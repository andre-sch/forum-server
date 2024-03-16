package com.forum.features.updateComment;

import com.forum.http.*;
import com.forum.entities.Comment;
import com.forum.views.CommentView;
import com.forum.providers.*;
import com.forum.providers.impl.*;

class UpdateCommentController implements HttpEndpointHandler {
  private UpdateCommentService updateCommentService;
  private JSONProvider JSON = new JSONProviderGoogleAdapter();

  public UpdateCommentController(UpdateCommentService updateCommentService) {
    this.updateCommentService = updateCommentService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String authenticatedUserId = (String) request.getSessionAttribute("userId");
    String commentId = request.getPathParam("commentId");

    RequestBody requestBody = this.JSON.deserialize(request.getBody(), RequestBody.class);

    CommentUpdateRequest updateRequest = new CommentUpdateRequest();

    updateRequest.authenticatedUserId = authenticatedUserId;
    updateRequest.commentId = commentId;
    updateRequest.content = requestBody.content;

    Comment updatedComment = this.updateCommentService.execute(updateRequest);
    CommentView updatedCommentView = new CommentView(updatedComment);

    response.json(updatedCommentView);
  }

  private class RequestBody {
    public String content;
  }
}

