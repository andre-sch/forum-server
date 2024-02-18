package com.forum.features.listThread;

import com.forum.http.HttpHandler;
import com.forum.repositories.Repository;
import com.forum.entities.Post;
import com.forum.entities.Comment;

public class ListThread {
  public ListThread(
    Repository<Post> postsRepository,
    Repository<Comment> commentsRepository
  ) {
    ListThreadService listThreadService = new ListThreadService(postsRepository);
    ListPostCommentsService listPostCommentsService = new ListPostCommentsService(commentsRepository);

    ListThreadController controller = new ListThreadController(
      listThreadService,
      listPostCommentsService
    );

    this.handler = controller;
  }

  public HttpHandler handler;
}
