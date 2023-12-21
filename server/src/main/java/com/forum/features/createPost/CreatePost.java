package com.forum.features.createPost;

import com.forum.http.HttpHandler;
import com.forum.repositories.PostsRepository;
import com.forum.repositories.UsersRepository;

public class CreatePost {
  public CreatePost(
    PostsRepository postsRepository,
    UsersRepository usersRepository
  ) {
    CreatePostService service = new CreatePostService(postsRepository, usersRepository);
    CreatePostController controller = new CreatePostController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
