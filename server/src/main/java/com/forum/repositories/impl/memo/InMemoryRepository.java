package com.forum.repositories.impl.memo;

import java.util.*;
import java.util.function.Predicate;

import com.forum.repositories.Repository;

public abstract class InMemoryRepository<T> implements Repository<T> {
  List<T> instances = new ArrayList<>();

  protected abstract String getInstanceId(T instance);

  public List<T> list(Predicate<T> condition) {
    return this.list().stream().filter(condition).toList();
  }

  public List<T> list() {
    return this.instances;
  }

  public T listOne(String id) {
    for (T instance : this.instances) {
      if (id.equals(this.getInstanceId(instance))) {
        return instance;
      }
    }
    return null;
  }

  public void save(T instance) {
    this.instances.add(instance);
  }

  public void update(T newInstance) {
    T oldInstance = this.listOne(this.getInstanceId(newInstance));
    int index = this.instances.indexOf(oldInstance);
    this.instances.set(index, newInstance);
  }
}
