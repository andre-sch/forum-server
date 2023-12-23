package com.forum.repositories;

import com.forum.entities.Comment;

public interface CommentsRepository {
  public Comment listOne(String id);
  public void create(Comment comment);
}
