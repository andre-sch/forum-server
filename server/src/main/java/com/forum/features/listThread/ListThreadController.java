package com.forum.features.listThread;

import java.util.List;
import com.forum.http.*;
import com.forum.entities.Post;

class ListThreadController implements HttpEndpointHandler {
  private ListThreadService listThreadService;
  private ListPostCommentsService listPostCommentsService;

  public ListThreadController(
    ListThreadService listThreadService,
    ListPostCommentsService listPostCommentsService
  ) {
    this.listThreadService = listThreadService;
    this.listPostCommentsService = listPostCommentsService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String postId = request.getPathParam("postId");

    List<CommentNode> comments = this.listPostCommentsService.execute(postId);
    Post post = this.listThreadService.execute(postId);

    Thread thread = new Thread(post, comments);

    response.json(thread);
  };
}
