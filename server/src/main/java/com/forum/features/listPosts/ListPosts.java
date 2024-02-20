package com.forum.features.listPosts;

import com.forum.http.HttpEndpointHandler;
import com.forum.repositories.Repository;
import com.forum.entities.Post;

public class ListPosts {
  public ListPosts(Repository<Post> postsRepository) {
    ListPostsService service = new ListPostsService(postsRepository);
    ListPostsController controller = new ListPostsController(service);

    this.handler = controller;
  }

  public HttpEndpointHandler handler;
}
