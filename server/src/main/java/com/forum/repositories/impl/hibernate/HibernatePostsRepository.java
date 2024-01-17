package com.forum.repositories.impl.hibernate;

import com.forum.Transaction;
import com.forum.entities.Post;

public class HibernatePostsRepository extends HibernateRepository<Post> {
  public HibernatePostsRepository(Transaction transaction) {
    super(Post.class, transaction);
  }
}
