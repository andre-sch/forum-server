package com.forum.features.createComment;

import com.forum.http.HttpHandler;
import com.forum.repositories.*;
import com.forum.entities.*;

public class CreateComment {
  public CreateComment(
    CommentsRepository commentsRepository,
    Repository<User> usersRepository,
    PostsRepository postsRepository
  ) {
    CreateCommentService service = new CreateCommentService(
      commentsRepository,
      usersRepository,
      postsRepository
    );

    CreateCommentController controller = new CreateCommentController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
