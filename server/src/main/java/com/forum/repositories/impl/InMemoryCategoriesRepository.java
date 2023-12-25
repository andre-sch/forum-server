package com.forum.repositories.impl;

import java.util.List;
import java.util.ArrayList;

import com.forum.entities.Category;
import com.forum.repositories.CategoriesRepository;

public class InMemoryCategoriesRepository implements CategoriesRepository {
  private List<Category> categories = new ArrayList<Category>();

  public List<Category> list() {
    return this.categories;
  }

  public Category listOne(String name) {
    for (Category category : this.categories) {
      if (name.equals(category.name)) {
        return category;
      }
    }
    return null;
  }

  public void create(Category category) {
    this.categories.add(category);
  }
}
