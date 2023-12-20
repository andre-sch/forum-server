package com.forum.repositories.impl;

import java.util.List;
import java.util.ArrayList;

import com.forum.entities.User;
import com.forum.repositories.UsersRepository;

public class InMemoryUsersRepository implements UsersRepository {
  private List<User> users = new ArrayList<User>();
  
  public void create(User user) {
    this.users.add(user);
  }
}
