package com.forum.repositories.impl.hibernate;

import com.forum.Transaction;
import com.forum.entities.User;

public class HibernateUsersRepository extends HibernateRepository<User> {
  public HibernateUsersRepository(Transaction transaction) {
    super(User.class, transaction);
  }
}
