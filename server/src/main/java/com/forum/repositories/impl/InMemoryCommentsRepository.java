package com.forum.repositories.impl;

import java.util.List;
import java.util.ArrayList;

import com.forum.entities.Comment;
import com.forum.repositories.CommentsRepository;

public class InMemoryCommentsRepository implements CommentsRepository {
  private List<Comment> comments = new ArrayList<Comment>();

  public Comment listOne(String id) {
    for (Comment comment : this.comments) {
      if (id.equals(comment.id)) {
        return comment;
      }
    }
    return null;
  }

  public void create(Comment comment) {
    this.comments.add(comment);
  }
}
