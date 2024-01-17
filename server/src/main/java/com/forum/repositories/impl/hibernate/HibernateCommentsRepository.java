package com.forum.repositories.impl.hibernate;

import com.forum.Transaction;
import com.forum.entities.Comment;

public class HibernateCommentsRepository extends HibernateRepository<Comment> {
  public HibernateCommentsRepository(Transaction transaction) {
    super(Comment.class, transaction);
  }
}
