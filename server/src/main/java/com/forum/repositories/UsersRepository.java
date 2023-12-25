package com.forum.repositories;

import java.util.List;
import com.forum.entities.User;

public interface UsersRepository {
  public List<User> list();
  public User listOne(String id);
  public void create(User user);
}
