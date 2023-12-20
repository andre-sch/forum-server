package com.forum.entities;

import java.util.UUID;
import com.forum.utils.Time;

public class User {
  public String id;
  public String name;
  public String email;
  public String password;
  public long created_at;

  public User(String name, String email, String password) {
    UUID uuid = UUID.randomUUID();
    this.id = uuid.toString();

    this.name = name;
    this.email = email;
    this.password = password;

    this.created_at = Time.now();
  }
}
