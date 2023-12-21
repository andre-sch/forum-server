package com.forum.features.listPosts;

import com.forum.http.HttpHandler;
import com.forum.repositories.PostsRepository;

public class ListPosts {
  public ListPosts(PostsRepository postsRepository) {
    ListPostsService service = new ListPostsService(postsRepository);
    ListPostsController controller = new ListPostsController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
