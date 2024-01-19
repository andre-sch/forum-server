package com.forum.repositories.impl.hibernate;

import com.forum.Transaction;
import com.forum.entities.Contribution;

public class HibernateContributionsRepository extends HibernateRepository<Contribution> {
  public HibernateContributionsRepository(Transaction transaction) {
    super(Contribution.class, transaction);
  }
}
