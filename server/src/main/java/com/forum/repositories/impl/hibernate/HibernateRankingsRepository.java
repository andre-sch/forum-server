package com.forum.repositories.impl.hibernate;

import com.forum.Transaction;
import com.forum.entities.Ranking;

public class HibernateRankingsRepository extends HibernateRepository<Ranking> {
  public HibernateRankingsRepository(Transaction transaction) {
    super(Ranking.class, transaction);
  }
}
