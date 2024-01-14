package com.forum.features.createCategory;

import com.forum.http.HttpHandler;
import com.forum.repositories.Repository;
import com.forum.entities.Category;

public class CreateCategory {
  public CreateCategory(Repository<Category> categoriesRepository) {
    CreateCategoryService service = new CreateCategoryService(categoriesRepository);
    CreateCategoryController controller = new CreateCategoryController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
