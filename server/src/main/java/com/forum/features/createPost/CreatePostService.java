package com.forum.features.createPost;

import com.forum.repositories.*;
import com.forum.entities.*;

class CreatePostService {
  private Repository<Post> postsRepository;
  private Repository<User> usersRepository;
  private Repository<Category> categoriesRepository;

  public CreatePostService(
    Repository<Post> postsRepository,
    Repository<User> usersRepository,
    Repository<Category> categoriesRepository
  ) {
    this.postsRepository = postsRepository;
    this.usersRepository = usersRepository;
    this.categoriesRepository = categoriesRepository;
  }

  public Post execute(PostCreationRequest creationRequest) {
    User author = this.usersRepository.listOne(creationRequest.author);

    if (author == null) {
      throw new Error("author does not exist");
    }

    for (String categoryName : creationRequest.categories) {
      Category category = this.categoriesRepository.listOne(categoryName);

      if (category == null) {
        throw new Error(String.format("category named '%s' does not exist", categoryName));
      }
    }

    Post post = new Post(
      creationRequest.author,
      creationRequest.title,
      creationRequest.content,
      creationRequest.categories
    );

    this.postsRepository.save(post);

    return post;
  }
}
