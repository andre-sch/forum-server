package com.forum.features.createUser;

import com.forum.entities.User;

class UserView {
  public String id;
  public String name;
  public String email;
  public long created_at;

  public UserView(User user) {
    this.id = user.id;
    this.name = user.name;
    this.email = user.email;
    this.created_at = user.created_at;
  }
}
