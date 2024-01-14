package com.forum.features.createPost;

import com.forum.http.HttpHandler;
import com.forum.repositories.*;
import com.forum.entities.*;

public class CreatePost {
  public CreatePost(
    Repository<Post> postsRepository,
    Repository<User> usersRepository,
    Repository<Category> categoriesRepository
  ) {
    CreatePostService service = new CreatePostService(
      postsRepository,
      usersRepository,
      categoriesRepository
    );

    CreatePostController controller = new CreatePostController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
