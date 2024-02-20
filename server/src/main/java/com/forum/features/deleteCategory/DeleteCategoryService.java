package com.forum.features.deleteCategory;

import com.forum.entities.Category;
import com.forum.repositories.Repository;
import com.forum.exceptions.domain.RequestException;

class DeleteCategoryService {
  private Repository<Category> categoriesRepository;

  public DeleteCategoryService(Repository<Category> categoriesRepository) {
    this.categoriesRepository = categoriesRepository;
  }

  public void execute(String categoryName) {
    Category category = this.categoriesRepository.listOne(categoryName);

    if (category == null) {
      throw new RequestException("category does not exist");
    }

    this.categoriesRepository.delete(categoryName);
  }
}
