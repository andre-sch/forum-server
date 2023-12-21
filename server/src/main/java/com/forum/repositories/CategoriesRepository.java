package com.forum.repositories;

public interface CategoriesRepository {
  public Category listOne(String name);
  public void create(Category post);
}
