package com.forum.features.listOnePost;

import com.forum.entities.Post;
import com.forum.repositories.Repository;

class ListOnePostService {
  private Repository<Post> postsRepository;

  public ListOnePostService(Repository<Post> postsRepository) {
    this.postsRepository = postsRepository;
  }

  public Post execute(String postId) {
    return this.postsRepository.listOne(postId);
  }
}
