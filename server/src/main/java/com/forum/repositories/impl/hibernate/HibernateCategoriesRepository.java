package com.forum.repositories.impl.hibernate;

import com.forum.Transaction;
import com.forum.entities.Category;

public class HibernateCategoriesRepository extends HibernateRepository<Category> {
  public HibernateCategoriesRepository(Transaction transaction) {
    super(Category.class, transaction);
  }
}
