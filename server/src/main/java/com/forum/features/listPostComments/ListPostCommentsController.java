package com.forum.features.listPostComments;

import java.util.List;
import com.forum.http.*;

class ListPostCommentsController implements HttpHandler {
  private ListPostCommentsService listPostCommentsService;

  public ListPostCommentsController(ListPostCommentsService listPostCommentsService) {
    this.listPostCommentsService = listPostCommentsService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    PostCommentsListingRequest listingRequest = new PostCommentsListingRequest();
    listingRequest.postId = request.getParam("postId");

    List<CommentNode> comments = this.listPostCommentsService.execute(listingRequest);

    response.json(comments);
  }
}
