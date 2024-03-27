package com.forum.features.updateUser;

import com.forum.http.*;
import com.forum.entities.User;
import com.forum.views.CompleteUserView;
import com.forum.providers.*;
import com.forum.providers.impl.*;

class UpdateUserController implements HttpEndpointHandler {
  private UpdateUserService updateUserService;
  private JSONProvider JSON = new JSONProviderGoogleAdapter();

  public UpdateUserController(UpdateUserService updateUserService) {
    this.updateUserService = updateUserService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String authenticatedUserId = (String) request.getSessionAttribute("userId");
    String updatedUserId = request.getPathParam("userId");

    RequestBody requestBody = this.JSON.deserialize(request.getBody(), RequestBody.class);

    UserUpdateRequest updateRequest =  new UserUpdateRequest();

    updateRequest.authenticatedUserId = authenticatedUserId;
    updateRequest.updatedUserId = updatedUserId;
    updateRequest.name = requestBody.name;
    updateRequest.email = requestBody.email;
    updateRequest.password = requestBody.password;
    updateRequest.avatarUrl = requestBody.avatarUrl;

    User updatedUser = this.updateUserService.execute(updateRequest);
    CompleteUserView updatedUserView = new CompleteUserView(updatedUser);

    response.json(updatedUserView);
  }

  private class RequestBody {
    public String name;
    public String email;
    public String password;
    public String avatarUrl;
  }
}
