package com.forum.features.listPostComments;

import com.forum.http.HttpHandler;
import com.forum.repositories.CommentsRepository;

public class ListPostComments {
  public ListPostComments(CommentsRepository commentsRepository) {
    ListPostCommentsService service = new ListPostCommentsService(commentsRepository);
    ListPostCommentsController controller = new ListPostCommentsController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
