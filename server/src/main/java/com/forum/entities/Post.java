package com.forum.entities;

import java.util.UUID;
import com.forum.utils.Time;

public class Post {
  public String id;
  public String author;
  public String title;
  public String content;
  public String[] categories;
  public int createdAt;
  public int lastUpdate;

  public Post(
    String author,
    String title,
    String content,
    String[] categories
  ) {
    UUID uuid = UUID.randomUUID();
    this.id = uuid.toString();

    this.author = author;
    this.title = title;
    this.content = content;
    this.categories = categories;

    this.createdAt = Time.now();
    this.lastUpdate = this.createdAt;
  }
}
