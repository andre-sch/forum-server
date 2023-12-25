package com.forum.repositories;

import java.util.List;
import com.forum.entities.Post;

public interface PostsRepository {
  public List<Post> list();
  public Post listOne(String id);
  public void create(Post post);
  public void update(Post newPost);
}
