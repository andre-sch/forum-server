package com.forum.features.listUsers;

import com.forum.entities.User;

class UserView {
  public String id;
  public String name;
  public String email;
  public String avatarUrl;
  public int createdAt;

  public UserView(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.avatarUrl = user.getAvatarUrl();
    this.createdAt = user.getCreationTimestamp();
  }
}
