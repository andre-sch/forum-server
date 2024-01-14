package com.forum.features.listCategories;

import java.util.List;
import com.forum.entities.Category;
import com.forum.repositories.Repository;

class ListCategoriesService {
  private Repository<Category> categoriesRepository;

  public ListCategoriesService(Repository<Category> categoriesRepository) {
    this.categoriesRepository = categoriesRepository;
  }

  public List<Category> execute() {
    return this.categoriesRepository.list();
  }
}
