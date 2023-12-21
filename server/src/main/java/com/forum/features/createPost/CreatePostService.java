package com.forum.features.createPost;

import com.forum.entities.Post;
import com.forum.entities.User;

import com.forum.repositories.PostsRepository;
import com.forum.repositories.UsersRepository;

class CreatePostService {
  private UsersRepository usersRepository;
  private PostsRepository postsRepository;

  public CreatePostService(
    PostsRepository postsRepository,
    UsersRepository usersRepository
  ) {
    this.postsRepository = postsRepository;
    this.usersRepository = usersRepository;
  }

  public Post execute(PostCreationRequest creationRequest) {
    User author = this.usersRepository.listOne(creationRequest.author);

    if (author == null) {
      throw new Error("author does not exist");
    }

    Post post = new Post(
      creationRequest.author,
      creationRequest.title,
      creationRequest.content
    );

    this.postsRepository.create(post);

    return post;
  }
}
