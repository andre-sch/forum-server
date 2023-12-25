package com.forum.features.createComment;

import com.forum.http.HttpHandler;
import com.forum.repositories.CommentsRepository;
import com.forum.repositories.PostsRepository;
import com.forum.repositories.UsersRepository;

public class CreateComment {
  public CreateComment(
    CommentsRepository commentsRepository,
    UsersRepository usersRepository,
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
