package com.forum.features.rankPost;

import com.forum.http.*;
import com.forum.entities.Post;
import com.google.gson.Gson;

class RankPostController implements HttpHandler {
  private String vote;
  private RankPostService rankPostService;
  private Gson jsonConverter = new Gson();

  public RankPostController(String vote, RankPostService service) {
    this.vote = vote;
    this.rankPostService = service;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String postId = request.getParam("postId");
    RequestBody body = this.jsonConverter.fromJson(request.body(), RequestBody.class);

    PostRankingRequest rankingRequest = new PostRankingRequest();

    rankingRequest.postId = postId;
    rankingRequest.userId = body.userId;
    rankingRequest.vote = this.vote;

    Post updatedPost = this.rankPostService.execute(rankingRequest);

    response.json(updatedPost);
  }

  class RequestBody {
    public String userId;
  }
}

