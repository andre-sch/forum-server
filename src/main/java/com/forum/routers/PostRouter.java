package com.forum.routers;

import com.forum.*;
import com.forum.http.*;
import com.forum.endpoints.*;
import com.forum.repositories.*;

import com.forum.features.listPosts.*;
import com.forum.features.listThread.*;
import com.forum.features.createPost.*;
import com.forum.features.updatePost.*;
import com.forum.features.deletePost.*;

public class PostRouter implements Router {
  private HttpApp app;
  private RestrictedEndpointFactory restrictedEndpoint = new RestrictedEndpointFactory();

  private UsersRepository usersRepository = Repositories.getUsersRepository();
  private PostsRepository postsRepository = Repositories.getPostsRepository();
  private CommentsRepository commentsRepository = Repositories.getCommentsRepository();
  private CategoriesRepository categoriesRepository = Repositories.getCategoriesRepository();

  public PostRouter(HttpApp app) {
    this.app = app;
  }

  public void bindEndpoints() {
    app.get("/posts", new ListPosts(postsRepository).handler);
    app.get("/posts/{postId}", new ListThread(postsRepository, commentsRepository).handler);

    app.post("/posts", restrictedEndpoint.create(
      new CreatePost(postsRepository, usersRepository, categoriesRepository).handler,
      "create-contribution"
    ));

    app.put("/posts/{postId}", restrictedEndpoint.create(
      new UpdatePost(postsRepository, categoriesRepository).handler,
      "update-contribution"
    ));

    app.delete("/posts/{postId}", restrictedEndpoint.create(
      new DeletePost(postsRepository).handler,
      "delete-contribution"
    ));
  }
}
