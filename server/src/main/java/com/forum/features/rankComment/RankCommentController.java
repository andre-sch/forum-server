package com.forum.features.rankComment;

import com.forum.http.*;
import com.forum.entities.Comment;
import com.google.gson.Gson;

class RankCommentController implements HttpHandler {
  private String vote;
  private RankCommentService rankCommentService;
  private Gson jsonConverter = new Gson();

  public RankCommentController(String vote, RankCommentService service) {
    this.vote = vote;
    this.rankCommentService = service;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String commentId = request.getParam("commentId");
    RequestBody body = this.jsonConverter.fromJson(request.body(), RequestBody.class);

    CommentRankingRequest rankingRequest = new CommentRankingRequest();

    rankingRequest.commentId = commentId;
    rankingRequest.userId = body.userId;
    rankingRequest.vote = this.vote;

    Comment updatedComment = this.rankCommentService.execute(rankingRequest);

    response.json(updatedComment);
  }

  class RequestBody {
    public String userId;
  }
}
