package com.forum.features.listOnePost;

import com.forum.http.HttpHandler;
import com.forum.repositories.PostsRepository;
import com.forum.repositories.CommentsRepository;

public class ListOnePost {
  public ListOnePost(
    PostsRepository postsRepository,
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
