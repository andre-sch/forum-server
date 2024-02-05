package com.forum.features.deleteCategory;

import com.forum.repositories.Repository;
import com.forum.entities.Category;

class DeleteCategoryService {
  private Repository<Category> categoriesRepository;

  public DeleteCategoryService(Repository<Category> categoriesRepository) {
    this.categoriesRepository = categoriesRepository;
  }

  public void execute(String categoryName) {
    Category category = this.categoriesRepository.listOne(categoryName);

    if (category == null) {
      throw new Error("category does not exist");
    }

    this.categoriesRepository.delete(categoryName);
  }
}
