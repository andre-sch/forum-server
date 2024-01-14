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
    ListOnePostService service = new ListOnePostService(
      postsRepository,
      new ListPostCommentsService(commentsRepository)
    );

    ListOnePostController controller = new ListOnePostController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
