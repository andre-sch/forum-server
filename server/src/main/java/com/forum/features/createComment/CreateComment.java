package com.forum.features.createComment;

import com.forum.http.HttpEndpointHandler;
import com.forum.repositories.*;
import com.forum.entities.*;

public class CreateComment {
  public CreateComment(
    Repository<Contribution> contributionsRepository,
    Repository<Comment> commentsRepository,
    Repository<User> usersRepository
  ) {
    CreateCommentService service = new CreateCommentService(
      contributionsRepository,
      commentsRepository,
      usersRepository
    );

    CreateCommentController controller = new CreateCommentController(service);

    this.handler = controller;
  }

  public HttpEndpointHandler handler;
}
