package com.forum.repositories;

import java.util.List;
import java.util.function.Predicate;

public interface Repository<T> {
  public List<T> list();
  public List<T> list(Predicate<T> condition);
  public T listOne(String id);
  public void save(T instance);
  public void update(T newInstance);
  // TODO: public void delete(String id);
}
