package com.forum.features.listThread;

import com.forum.entities.Post;
import com.forum.repositories.Repository;

class ListThreadService {
  private Repository<Post> postsRepository;

  public ListThreadService(Repository<Post> postsRepository) {
    this.postsRepository = postsRepository;
  }

  public Post execute(String postId) {
    return this.postsRepository.listOne(postId);
  }
}
