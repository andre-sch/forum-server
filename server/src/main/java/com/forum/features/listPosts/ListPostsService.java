package com.forum.features.listPosts;

import java.util.List;
import com.forum.entities.Post;
import com.forum.repositories.PostsRepository;

class ListPostsService {
  private PostsRepository postsRepository;

  public ListPostsService(PostsRepository postsRepository) {
    this.postsRepository = postsRepository;
  }

  public List<Post> execute() {
    return this.postsRepository.list();
  }
}
