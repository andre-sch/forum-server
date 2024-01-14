package com.forum.features.rankPost;

import com.forum.http.HttpHandler;
import com.forum.repositories.Repository;
import com.forum.entities.Post;

public class RankPost {
  public RankPost(String vote, Repository<Post> postsRepository) {
    RankPostService service = new RankPostService(postsRepository);
    RankPostController controller = new RankPostController(vote, service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
