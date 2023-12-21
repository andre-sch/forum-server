package com.forum.features.createPost;

import com.forum.http.*;
import com.forum.entities.Post;
import com.google.gson.Gson;

class CreatePostController implements HttpHandler {
  private CreatePostService createPostService;
  private Gson jsonConverter = new Gson();

  public CreatePostController(CreatePostService service) {
    this.createPostService = service;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    PostCreationRequest creationRequest = this.jsonConverter.fromJson(request.body(), PostCreationRequest.class);

    Post createdPost = this.createPostService.execute(creationRequest);

    response.status(201);
    response.json(createdPost);
  }
}
