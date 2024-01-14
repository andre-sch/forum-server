package com.forum.repositories.impl;

import com.forum.entities.Post;

public class InMemoryPostsRepository extends InMemoryRepository<Post> {
  protected String getInstanceId(Post instance) {
    return instance.getId();
  }
}
