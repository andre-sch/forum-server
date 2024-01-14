package com.forum.features.listPosts;

import java.util.List;
import com.forum.entities.Post;
import com.forum.repositories.Repository;

class ListPostsService {
  private Repository<Post> postsRepository;

  public ListPostsService(Repository<Post> postsRepository) {
    this.postsRepository = postsRepository;
  }

  public List<Post> execute() {
    return this.postsRepository.list();
  }
}
