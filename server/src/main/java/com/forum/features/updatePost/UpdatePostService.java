package com.forum.features.updatePost;

import java.util.*;

import com.forum.repositories.Repository;
import com.forum.entities.Category;
import com.forum.entities.Post;

class UpdatePostService {
  private Repository<Post> postsRepository;
  private Repository<Category> categoriesRepository;

  public UpdatePostService(
    Repository<Post> postsRepository,
    Repository<Category> categoriesRepository
  ) {
    this.postsRepository = postsRepository;
    this.categoriesRepository = categoriesRepository;
  }


  public Post execute(PostUpdateRequest updateRequest) {
    Post post = this.postsRepository.listOne(updateRequest.postId);

    if (post == null) {
      throw new Error("post does not exist");
    }

    if (updateRequest.title != null) {
      post.setTitle(updateRequest.title);
    }

    if (updateRequest.content != null) {
      post.setContent(updateRequest.content);
    }

    if (updateRequest.categoryNames != null) {
      Set<Category> categories = new HashSet<>();

      for (String categoryName : updateRequest.categoryNames) {
        Category category = this.categoriesRepository.listOne(categoryName);

        if (category == null) {
          throw new Error(String.format("category named '%s' does not exist", categoryName));
        }

        categories.add(category);
      }

      post.setCategories(categories);
    }

    this.postsRepository.update(post);

    return post;
  }
}