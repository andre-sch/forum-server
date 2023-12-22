package com.forum.entities;

import java.util.UUID;
import com.forum.utils.Time;

public class Post {
  public String id;
  public String title;
  public String content;
  public String author;
  public String[] categories;
  public int created_at;
  public int last_update;

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

    this.created_at = Time.now();
    this.last_update = Time.now();
  }
}
