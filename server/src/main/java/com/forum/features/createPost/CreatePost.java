package com.forum.features.createPost;

import com.forum.http.HttpHandler;
import com.forum.repositories.PostsRepository;
import com.forum.repositories.UsersRepository;
import com.forum.repositories.CategoriesRepository;

public class CreatePost {
  public CreatePost(
    PostsRepository postsRepository,
    UsersRepository usersRepository,
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
