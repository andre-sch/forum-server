package com.forum.features.listThread;

import com.forum.entities.Post;
import com.forum.repositories.PostsRepository;

class ListPostContentService {
  private PostsRepository postsRepository;

  public ListPostContentService(PostsRepository postsRepository) {
    this.postsRepository = postsRepository;
  }

  public Post execute(String postId) {
    return this.postsRepository.listOne(postId);
  }
}
