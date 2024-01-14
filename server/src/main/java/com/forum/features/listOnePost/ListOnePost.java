package com.forum.features.listOnePost;

import com.forum.http.HttpHandler;
import com.forum.repositories.CommentsRepository;
import com.forum.repositories.Repository;
import com.forum.entities.Post;

public class ListOnePost {
  public ListOnePost(
    Repository<Post> postsRepository,
    CommentsRepository commentsRepository
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
