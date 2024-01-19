package com.forum.features.listOnePost;

import com.forum.http.HttpHandler;
import com.forum.repositories.Repository;
import com.forum.entities.Post;
import com.forum.entities.Comment;

public class ListOnePost {
  public ListOnePost(
    Repository<Post> postsRepository,
    Repository<Comment> commentsRepository
  ) {
    ListOnePostService listOnePostService = new ListOnePostService(postsRepository);
    ListPostCommentsService listPostCommentsService = new ListPostCommentsService(commentsRepository);

    ListOnePostController controller = new ListOnePostController(
      listOnePostService,
      listPostCommentsService
    );

    this.handler = controller;
  }

  public HttpHandler handler;
}
