package com.forum.repositories.impl;

import java.util.List;
import java.util.ArrayList;

import com.forum.entities.User;
import com.forum.repositories.UsersRepository;

public class InMemoryUsersRepository implements UsersRepository {
  private List<User> users = new ArrayList<User>();

  public List<User> list() {
    return this.users;
  }

  public User listOne(String id) {
    for (User user : this.users) {
      if (id.equals(user.id)) {
        return user;
      }
    }
    return null;
  }

  public void create(User user) {
    this.users.add(user);
  }
}
