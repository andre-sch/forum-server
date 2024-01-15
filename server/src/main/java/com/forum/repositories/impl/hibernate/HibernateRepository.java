package com.forum.repositories.impl.hibernate;

import java.util.List;
import java.util.function.Predicate;

import com.forum.Transaction;
import com.forum.repositories.Repository;

public class HibernateRepository<T> implements Repository<T> {
  private Class<T> persistedClass;
  private Transaction transaction;

  public HibernateRepository(
    Class<T> persistedClass,
    Transaction transaction
  ) {
    this.persistedClass = persistedClass;
    this.transaction = transaction;
  }

  public List<T> list(Predicate<T> condition) {
    return this.list().stream().filter(condition).toList();
  }

  public List<T> list() {
    ResultList result = new ResultList();

    this.transaction.execute((entityManager) -> {
      result.instances = entityManager
        .createQuery(
          String.format("from %s", this.persistedClass.getName()),
          this.persistedClass
        )
        .getResultList();
    });

    return result.instances;
  }

  public T listOne(String id) {
    SingleResult result = new SingleResult();

    this.transaction.execute((entityManager) -> {
      result.instance = entityManager.find(this.persistedClass, id);
    });

    return result.instance;
  }

  public void save(T instance) {
    this.transaction.execute((entityManager) -> entityManager.persist(instance));
  }

  public void update(T newInstance) {
    this.transaction.execute((entityManager) -> entityManager.merge(newInstance));
  }

  private class SingleResult { T instance; }
  private class ResultList { List<T> instances; }
}