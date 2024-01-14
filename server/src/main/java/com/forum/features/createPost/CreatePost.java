package com.forum.features.createPost;

import com.forum.http.HttpHandler;
import com.forum.repositories.*;
import com.forum.entities.*;

public class CreatePost {
  public CreatePost(
    PostsRepository postsRepository,
    Repository<User> usersRepository,
    CategoriesRepository categoriesRepository
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
