package com.forum.features.listCategories;

import java.util.List;
import com.forum.entities.Category;
import com.forum.http.*;

class ListCategoriesController implements HttpHandler {
  private ListCategoriesService listCategoriesService;

  public ListCategoriesController(ListCategoriesService service) {
    this.listCategoriesService = service;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    List<Category> categories = this.listCategoriesService.execute();
    response.json(categories);
  }
}
