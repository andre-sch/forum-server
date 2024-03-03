package com.forum.features.listCategories;

import java.util.List;
import com.forum.entities.Category;
import com.forum.repositories.CategoriesRepository;

class ListCategoriesService {
  private CategoriesRepository categoriesRepository;

  public ListCategoriesService(CategoriesRepository categoriesRepository) {
    this.categoriesRepository = categoriesRepository;
  }

  public List<Category> execute() {
    return this.categoriesRepository.list();
  }
}
