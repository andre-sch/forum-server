package com.forum.features.updateComment;

import com.forum.entities.Comment;
import com.forum.http.HttpHandler;
import com.forum.repositories.Repository;

public class UpdateComment {
  public UpdateComment(Repository<Comment> commentsRepository) {
    UpdateCommentService service = new UpdateCommentService(commentsRepository);
    UpdateCommentController controller = new UpdateCommentController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
