package com.forum.features.deleteCategory;

import com.forum.http.HttpHandler;
import com.forum.repositories.Repository;
import com.forum.entities.Category;

public class DeleteCategory {
  public DeleteCategory(Repository<Category> categoriesRepository) {
    DeleteCategoryService service = new DeleteCategoryService(categoriesRepository);
    DeleteCategoryController controller = new DeleteCategoryController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
