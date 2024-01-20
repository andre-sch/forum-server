package com.forum.features.listPosts;

import java.util.List;
import com.forum.entities.Post;
import com.forum.views.CompletePostView;
import com.forum.http.*;

class ListPostsController implements HttpHandler {
  private ListPostsService listPostsService;

  public ListPostsController(ListPostsService listPostsService) {
    this.listPostsService = listPostsService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    List<Post> posts = this.listPostsService.execute();
    List<CompletePostView> postViews = posts.stream().map(CompletePostView::new).toList();

    response.json(postViews);
  };
}
