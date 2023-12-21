package com.forum.entities;

import java.util.UUID;
import com.forum.utils.Time;

public class Post {
  public String id;
  public String author;
  public String title;
  public String content;
  public long created_at;
  public long last_update;

  public Post(String author, String title, String content) {
    UUID uuid = UUID.randomUUID();
    this.id = uuid.toString();

    this.author = author;
    this.title = title;
    this.content = content;

    this.created_at = Time.now();
    this.last_update = Time.now();
  }
}
