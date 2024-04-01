package com.forum.features.deletePost;

import com.forum.http.HttpEndpointHandler;
import com.forum.repositories.PostsRepository;

public class DeletePost {
  public DeletePost(PostsRepository postsRepository) {
    DeletePostService service = new DeletePostService(postsRepository);
    DeletePostController controller = new DeletePostController(service);

    this.handler = controller;
  }

  public HttpEndpointHandler handler;
}
