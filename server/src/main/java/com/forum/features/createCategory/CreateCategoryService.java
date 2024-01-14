package com.forum.features.createCategory;

import com.forum.entities.Category;
import com.forum.repositories.Repository;

class CreateCategoryService {
  private Repository<Category> categoriesRepository;

  public CreateCategoryService(Repository<Category> categoriesRepository) {
    this.categoriesRepository = categoriesRepository;
  }

  public Category execute(CategoryCreationRequest creationRequest) {
    Category category = this.categoriesRepository.listOne(creationRequest.name);

    if (category != null) {
      throw new Error("category already exists");
    }

    category = new Category(
      creationRequest.name,
      creationRequest.description
    );

    this.categoriesRepository.create(category);

    return category;
  }
}
