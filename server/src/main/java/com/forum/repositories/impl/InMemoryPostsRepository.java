package com.forum.repositories.impl;

import java.util.List;
import java.util.ArrayList;

import com.forum.entities.Post;
import com.forum.repositories.PostsRepository;

public class InMemoryPostsRepository implements PostsRepository {
  private List<Post> posts = new ArrayList<Post>();

  public List<Post> list() {
    return this.posts;
  }

  public Post listOne(String id) {
    for (Post post : this.posts) {
      if (id.equals(post.id)) {
        return post;
      }
    }
    return null;
  }

  public void create(Post post) {
    this.posts.add(post);
  }
}
