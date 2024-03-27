package com.forum.features.deleteComment;

import com.forum.http.HttpEndpointHandler;
import com.forum.repositories.CommentsRepository;

public class DeleteComment {
  public DeleteComment(CommentsRepository commentsRepository) {
    DeleteCommentService service = new DeleteCommentService(commentsRepository);
    DeleteCommentController controller = new DeleteCommentController(service);

    this.handler = controller;
  }

  public HttpEndpointHandler handler;
}
