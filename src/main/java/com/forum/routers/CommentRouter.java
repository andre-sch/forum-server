package com.forum.routers;

import com.forum.*;
import com.forum.http.*;
import com.forum.endpoints.*;
import com.forum.repositories.*;

import com.forum.features.createComment.*;
import com.forum.features.updateComment.*;
import com.forum.features.deleteComment.*;

public class CommentRouter implements Router {
  private HttpApp app;
  private RestrictedEndpointFactory restrictedEndpoint = new RestrictedEndpointFactory();

  private UsersRepository usersRepository = Repositories.getUsersRepository();
  private ContributionsRepository contributionsRepository = Repositories.getContributionsRepository();
  private CommentsRepository commentsRepository = Repositories.getCommentsRepository();

  public CommentRouter(HttpApp app) {
    this.app = app;
  }

  public void bindEndpoints() {
    this.app.post("/comments", restrictedEndpoint.create(
      new CreateComment(contributionsRepository, commentsRepository, usersRepository).handler,
      "create-contribution"
    ));

    this.app.put("/comments/{commentId}", restrictedEndpoint.create(
      new UpdateComment(commentsRepository).handler,
      "update-contribution"
    ));

    this.app.delete("/comments/{commentId}", restrictedEndpoint.create(
      new DeleteComment(commentsRepository).handler,
      "delete-contribution"
    ));
  }
}
