package com.forum.features.listThread;

import com.forum.entities.Post;
import com.forum.repositories.Repository;

class ListPostContentService {
  private Repository<Post> postsRepository;

  public ListPostContentService(Repository<Post> postsRepository) {
    this.postsRepository = postsRepository;
  }

  public Post execute(String postId) {
    return this.postsRepository.listOne(postId);
  }
}
