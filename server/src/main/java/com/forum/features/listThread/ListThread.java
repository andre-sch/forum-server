package com.forum.features.listThread;

import com.forum.http.HttpEndpointHandler;
import com.forum.repositories.Repository;
import com.forum.entities.Post;
import com.forum.entities.Comment;

public class ListThread {
  public ListThread(
    Repository<Post> postsRepository,
    Repository<Comment> commentsRepository
  ) {
    ListPostContentService listPostContentService = new ListPostContentService(postsRepository);
    ListPostCommentsService listPostCommentsService = new ListPostCommentsService(commentsRepository);

    ListThreadController controller = new ListThreadController(
      listPostContentService,
      listPostCommentsService
    );

    this.handler = controller;
  }

  public HttpEndpointHandler handler;
}
