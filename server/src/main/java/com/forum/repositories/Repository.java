package com.forum.repositories;

import java.util.List;

public interface Repository<T> {
  public List<T> list();
  public T listOne(String id);
  public void save(T instance);
  public void update(T newInstance);
  public void delete(String id);
}
