package com.forum.entities;

import java.util.*;
import com.forum.utils.Time;

public class Comment {
  public String id;
  public String parentId;
  public String content;
  public String author;
  public long createdAt;
  public long lastUpdate;

  public Comment(
    String parentId,
    String content,
    String author
  ) {
    UUID uuid = UUID.randomUUID();
    this.id = uuid.toString();

    this.parentId = parentId;
    this.content = content;
    this.author = author;

    this.createdAt = Time.now();
    this.lastUpdate = this.createdAt;
  }
}
