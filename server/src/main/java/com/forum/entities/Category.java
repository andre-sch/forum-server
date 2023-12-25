package com.forum.entities;

import com.forum.utils.Time;

public class Category {
  public String name;
  public String description;
  public int createdAt;

  public Category(String name, String description) {
    this.name = name;
    this.description = description;
    this.createdAt = Time.now();
  }
}
