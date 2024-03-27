package com.forum.routers;

import com.forum.*;
import com.forum.http.*;
import com.forum.endpoints.*;
import com.forum.repositories.*;

import com.forum.features.listCategories.*;
import com.forum.features.createCategory.*;
import com.forum.features.updateCategory.*;
import com.forum.features.deleteCategory.*;

public class CategoryRouter implements Router {
  private HttpApp app;
  private RestrictedEndpointFactory restrictedEndpoint = new RestrictedEndpointFactory();

  private CategoriesRepository categoriesRepository = Repositories.getCategoriesRepository();

  public CategoryRouter(HttpApp app) {
    this.app = app;
  }

  public void bindEndpoints() {
    this.app.get("/categories", new ListCategories(categoriesRepository).handler);

    this.app.post("/categories", restrictedEndpoint.create(
      new CreateCategory(categoriesRepository).handler,
      "create-category"
    ));

    this.app.put("/categories/{categoryName}", restrictedEndpoint.create(
      new UpdateCategory(categoriesRepository).handler,
      "update-category"
    ));

    this.app.delete("/categories/{categoryName}", restrictedEndpoint.create(
      new DeleteCategory(categoriesRepository).handler,
      "delete-category"
    ));
  }
}
