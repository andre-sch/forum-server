package com.forum.features.updatePost;

import com.forum.entities.Category;
import com.forum.entities.Post;
import com.forum.http.HttpHandler;
import com.forum.repositories.Repository;

public class UpdatePost {
  public UpdatePost(
    Repository<Post> postsRepository,
    Repository<Category> categoriesRepository
  ) {
    UpdatePostService service = new UpdatePostService(postsRepository, categoriesRepository);
    UpdatePostController controller = new UpdatePostController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
