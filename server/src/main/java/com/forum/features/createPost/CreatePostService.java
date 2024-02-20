package com.forum.features.createPost;

import java.util.*;
import com.forum.repositories.*;
import com.forum.entities.*;
import com.forum.exceptions.domain.RequestException;

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
    User author = this.usersRepository.listOne(creationRequest.authorId);

    if (author == null) {
      throw new RequestException("author does not exist");
    }

    Set<Category> categories = new HashSet<>();
    for (String categoryName : creationRequest.categoryNames) {
      Category category = this.categoriesRepository.listOne(categoryName);

      if (category == null) {
        throw new RequestException(String.format("category named '%s' does not exist", categoryName));
      }

      categories.add(category);
    }

    Post post = new Post();
    post.setAuthor(author);
    post.setTitle(creationRequest.title);
    post.setContent(creationRequest.content);
    post.setCategories(categories);

    this.postsRepository.save(post);

    return post;
  }
}
