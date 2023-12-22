package com.forum.entities;

import java.util.UUID;
import com.forum.utils.Time;

public class Post {
  public String id;
  public String title;
  public String content;
  public String author;
  public String[] categories;
  public int createdAt;
  public int lastUpdate;

  public Post(
    String title,
    String content,
    String author,
    String[] categories
  ) {
    UUID uuid = UUID.randomUUID();
    this.id = uuid.toString();

    this.title = title;
    this.content = content;
    this.author = author;
    this.categories = categories;

    this.createdAt = Time.now();
    this.lastUpdate = this.createdAt;
  }
}
