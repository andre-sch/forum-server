package com.forum.entities;

import java.util.UUID;
import com.forum.utils.Time;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
  @Id
  private String id;
  private String name;
  private String email;
  private String password;
  private String avatarUrl;
  private int createdAt;

  public User() {
    UUID uuid = UUID.randomUUID();
    this.id = uuid.toString();

    this.createdAt = Time.now();
  }

  public String getId() { return this.id; }
  public String getName() { return this.name; }
  public String getEmail() { return this.email; }
  public String getPassword() { return this.password; }
  public String getAvatarUrl() { return this.avatarUrl; }
  public int getCreationTimestamp() { return this.createdAt; }

  public void setName(String name) { this.name = name; }
  public void setEmail(String email) { this.email = email; }
  public void setPassword(String password) { this.password = password; }
  public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }
}
