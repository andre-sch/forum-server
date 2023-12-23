package com.forum.features.createComment;

import com.forum.http.*;
import com.forum.entities.Comment;
import com.google.gson.Gson;

class CreateCommentController implements HttpHandler {
  private CreateCommentService createCommentService;
  private Gson jsonParser = new Gson();

  public CreateCommentController(CreateCommentService service) {
    this.createCommentService = service;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    CommentCreationRequest creationRequest = this.jsonParser.fromJson(request.body(), CommentCreationRequest.class);

    Comment createdComment = this.createCommentService.execute(creationRequest);

    response.status(201);
    response.json(createdComment);
  }
}
