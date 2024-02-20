package com.forum.features.createPost;

import com.forum.http.*;
import com.forum.entities.Post;
import com.forum.views.CompactPostView;
import com.google.gson.Gson;

class CreatePostController implements HttpEndpointHandler {
  private CreatePostService createPostService;
  private Gson jsonConverter = new Gson();

  public CreatePostController(CreatePostService service) {
    this.createPostService = service;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    PostCreationRequest creationRequest = this.jsonConverter.fromJson(request.getBody(), PostCreationRequest.class);

    Post createdPost = this.createPostService.execute(creationRequest);
    CompactPostView createdPostView = new CompactPostView(createdPost);

    response.status(201);
    response.json(createdPostView);
  }
}
