package com.forum.entities;

import java.util.*;
import com.forum.utils.Time;

public class Comment {
  public String id;
  public String parentId;
  public String author;
  public String content;
  public Rank rank;
  public int createdAt;
  public int lastUpdate;

  public Comment(
    String parentId,
    String author,
    String content
  ) {
    UUID uuid = UUID.randomUUID();
    this.id = uuid.toString();

    this.parentId = parentId;
    this.author = author;
    this.content = content;

    this.rank = new Rank();

    this.createdAt = Time.now();
    this.lastUpdate = this.createdAt;
  }
}
