package com.forum.features.listOnePost;

import com.forum.http.*;

class ListOnePostController implements HttpHandler {
  private ListOnePostService listOnePostService;

  public ListOnePostController(ListOnePostService service) {
    this.listOnePostService = service;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String postId = request.getParam("postId");

    PostThread thread = this.listOnePostService.execute(postId);

    response.json(thread);
  };
}
