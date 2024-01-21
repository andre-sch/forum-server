package com.forum.features.listOnePost;

import java.util.List;
import com.forum.http.*;
import com.forum.entities.Post;

class ListOnePostController implements HttpHandler {
  private ListOnePostService listOnePostService;
  private ListPostCommentsService listPostCommentsService;

  public ListOnePostController(
    ListOnePostService listOnePostService,
    ListPostCommentsService listPostCommentsService
  ) {
    this.listOnePostService = listOnePostService;
    this.listPostCommentsService = listPostCommentsService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String postId = request.getPathParam("postId");

    List<CommentNode> comments = this.listPostCommentsService.execute(postId);
    Post post = this.listOnePostService.execute(postId);

    PostThread thread = new PostThread(post, comments);

    response.json(thread);
  };
}
