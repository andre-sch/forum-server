package com.forum.features.listCategories;

import com.forum.entities.Category;

class CategoryView {
  public String name;
  public String description;
  public String color;
  public int createdAt;

  public CategoryView(Category category) {
    this.name = category.getName();
    this.description = category.getDescription();
    this.color = category.getColor();
    this.createdAt = category.getCreationTimestamp();
  }
}
