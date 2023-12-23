package com.forum.repositories;

import java.util.List;
import java.util.function.Predicate;
import com.forum.entities.Comment;

public interface CommentsRepository {
  public List<Comment> list();
  public List<Comment> list(Predicate<Comment> filter);
  public Comment listOne(String id);
  public void create(Comment comment);
}
