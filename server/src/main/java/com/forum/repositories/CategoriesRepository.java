package com.forum.repositories;

import java.util.List;
import com.forum.entities.Category;

public interface CategoriesRepository {
  public List<Category> list();
  public Category listOne(String name);
  public void create(Category post);
}
