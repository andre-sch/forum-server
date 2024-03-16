package com.forum.features.updateCategory;

import com.forum.http.*;
import com.forum.entities.Category;
import com.forum.views.CompleteCategoryView;
import com.forum.providers.*;
import com.forum.providers.impl.*;

class UpdateCategoryController implements HttpEndpointHandler {
  private UpdateCategoryService updateCategoryService;
  private JSONProvider JSON = new JSONProviderGoogleAdapter();

  public UpdateCategoryController(UpdateCategoryService updateCategoryService) {
    this.updateCategoryService = updateCategoryService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String categoryName = request.getPathParam("categoryName");
    RequestBody requestBody = this.JSON.deserialize(request.getBody(), RequestBody.class);

    CategoryUpdateRequest updateRequest = new CategoryUpdateRequest();

    updateRequest.name = categoryName;
    updateRequest.description = requestBody.description;
    updateRequest.color = requestBody.color;

    Category updatedCategory = this.updateCategoryService.execute(updateRequest);
    CompleteCategoryView updatedCategoryView = new CompleteCategoryView(updatedCategory);

    response.json(updatedCategoryView);
  }

  private class RequestBody {
    public String description;
    public String color;
  }
}
