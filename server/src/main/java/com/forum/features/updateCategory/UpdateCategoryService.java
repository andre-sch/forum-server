package com.forum.features.updateCategory;

import com.forum.repositories.Repository;
import com.forum.entities.Category;

class UpdateCategoryService {
  private Repository<Category> categoriesRepository;

  public UpdateCategoryService(Repository<Category> categoriesRepository) {
    this.categoriesRepository = categoriesRepository;
  }

  public Category execute(CategoryUpdateRequest updateRequest) {
    Category category = categoriesRepository.listOne(updateRequest.name);

    if (category == null) {
      throw new Error("category does not exist");
    }

    if (updateRequest.description != null) {
      category.setDescription(updateRequest.description);
    }

    if (updateRequest.color != null) {
      if (updateRequest.color.startsWith("#")) {
        updateRequest.color = updateRequest.color.substring(1);
      }

      category.setColor(updateRequest.color);
    }

    categoriesRepository.update(category);

    return category;
  }
}
