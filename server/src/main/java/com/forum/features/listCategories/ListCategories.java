package com.forum.features.listCategories;

import com.forum.http.HttpHandler;
import com.forum.repositories.CategoriesRepository;

public class ListCategories {
  public ListCategories(CategoriesRepository categoriesRepository) {
    ListCategoriesService service = new ListCategoriesService(categoriesRepository);
    ListCategoriesController controller = new ListCategoriesController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
