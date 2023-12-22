package com.forum.entities;

import com.forum.utils.Time;

public class Category {
  public String name;
  public String description;
  public int created_at;

  public Category(String name, String description) {
    this.name = name;
    this.description = description;
    this.created_at = Time.now();
  }
}
