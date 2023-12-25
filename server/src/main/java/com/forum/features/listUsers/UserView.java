package com.forum.features.listUsers;

import com.forum.entities.User;

class UserView {
  public String id;
  public String name;
  public String email;
  public String avatarUrl;
  public int createdAt;

  public UserView(User user) {
    this.id = user.id;
    this.name = user.name;
    this.email = user.email;
    this.avatarUrl = user.avatarUrl;
    this.createdAt = user.createdAt;
  }
}
