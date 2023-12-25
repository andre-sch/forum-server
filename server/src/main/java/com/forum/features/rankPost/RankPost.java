package com.forum.features.rankPost;

import com.forum.http.HttpHandler;
import com.forum.repositories.PostsRepository;

public class RankPost {
  public RankPost(String vote, PostsRepository postsRepository) {
    RankPostService service = new RankPostService(postsRepository);
    RankPostController controller = new RankPostController(vote, service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
