package com.forum.features.createPost;

import com.forum.entities.Post;
import com.forum.entities.User;
import com.forum.entities.Category;

import com.forum.repositories.PostsRepository;
import com.forum.repositories.UsersRepository;
import com.forum.repositories.CategoriesRepository;

class CreatePostService {
  private PostsRepository postsRepository;
  private UsersRepository usersRepository;
  private CategoriesRepository categoriesRepository;

  public CreatePostService(
    PostsRepository postsRepository,
    UsersRepository usersRepository,
    CategoriesRepository categoriesRepository
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

    this.postsRepository.create(post);

    return post;
  }
}
