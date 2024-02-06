package com.forum.features.updateCategory;

import com.forum.http.HttpHandler;
import com.forum.repositories.Repository;
import com.forum.entities.Category;

public class UpdateCategory {
  public UpdateCategory(Repository<Category> categoriesRepository) {
    UpdateCategoryService service = new UpdateCategoryService(categoriesRepository);
    UpdateCategoryController controller = new UpdateCategoryController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
