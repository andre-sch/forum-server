package com.forum.repositories.impl;

import com.forum.entities.User;

public class InMemoryUsersRepository extends InMemoryRepository<User> {
  protected String getInstanceId(User instance) {
    return instance.getId();
  }
}
