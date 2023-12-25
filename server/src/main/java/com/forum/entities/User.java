package com.forum.entities;

import java.util.UUID;
import com.forum.utils.Time;

public class User {
  public String id;
  public String name;
  public String email;
  public String password;
  public String avatarUrl;
  public int createdAt;

  public User(
    String name,
    String email,
    String password,
    String avatarUrl
  ) {
    UUID uuid = UUID.randomUUID();
    this.id = uuid.toString();

    this.name = name;
    this.email = email;
    this.password = password;
    this.avatarUrl = avatarUrl;

    this.createdAt = Time.now();
  }
}
