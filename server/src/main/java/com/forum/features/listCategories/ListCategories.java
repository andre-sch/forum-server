package com.forum.features.listCategories;

import com.forum.http.HttpHandler;
import com.forum.repositories.Repository;
import com.forum.entities.Category;

public class ListCategories {
  public ListCategories(Repository<Category> categoriesRepository) {
    ListCategoriesService service = new ListCategoriesService(categoriesRepository);
    ListCategoriesController controller = new ListCategoriesController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
