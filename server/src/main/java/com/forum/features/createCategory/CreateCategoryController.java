package com.forum.features.createCategory;

import com.forum.http.*;
import com.forum.entities.Category;
import com.forum.views.CompleteCategoryView;
import com.forum.providers.*;
import com.forum.providers.impl.*;

class CreateCategoryController implements HttpEndpointHandler {
  private CreateCategoryService createCategoryService;
  private JSONProvider JSON = new JSONProviderGoogleAdapter();

  public CreateCategoryController(CreateCategoryService service) {
    this.createCategoryService = service;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    var creationRequest = this.JSON.deserialize(request.getBody(), CategoryCreationRequest.class);

    Category createdCategory = this.createCategoryService.execute(creationRequest);
    CompleteCategoryView createdCategoryView = new CompleteCategoryView(createdCategory);

    response.status(201);
    response.json(createdCategoryView);
  }
}
