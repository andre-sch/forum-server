package com.forum.features.updatePost;

import com.forum.http.*;
import com.forum.entities.Post;
import com.forum.views.CompactPostView;
import com.forum.providers.*;
import com.forum.providers.impl.*;

class UpdatePostController implements HttpEndpointHandler {
  private UpdatePostService updatePostService;
  private JSONProvider JSON = new JSONProviderGoogleAdapter();

  public UpdatePostController(UpdatePostService updatePostService) {
    this.updatePostService = updatePostService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String authenticatedUserId = (String) request.getSessionAttribute("userId");
    String postId = request.getPathParam("postId");

    RequestBody requestBody = this.JSON.deserialize(request.getBody(), RequestBody.class);

    PostUpdateRequest updateRequest = new PostUpdateRequest();

    updateRequest.authenticatedUserId = authenticatedUserId;
    updateRequest.postId = postId;
    updateRequest.title = requestBody.title;
    updateRequest.content = requestBody.content;
    updateRequest.categoryNames = requestBody.categoryNames;

    Post updatedPost = this.updatePostService.execute(updateRequest);
    CompactPostView updatedPostView = new CompactPostView(updatedPost);

    response.json(updatedPostView);
  }

  private class RequestBody {
    public String title;
    public String content;
    public String[] categoryNames;
  }
}
