package com.forum.features.rankContribution;

import com.forum.http.*;
import com.forum.entities.Ranking;
import com.google.gson.Gson;

class RankContributionController implements HttpHandler {
  private RankContributionService rankContributionService;
  private Gson jsonConverter = new Gson();

  public RankContributionController(RankContributionService service) {
    this.rankContributionService = service;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String contributionId = request.getParam("contributionId");
    String action = request.getParam("action");

    RequestBody body = this.jsonConverter.fromJson(request.body(), RequestBody.class);

    ContributionRankingRequest rankingRequest = new ContributionRankingRequest();

    rankingRequest.userId = body.userId;
    rankingRequest.contributionId = contributionId;
    rankingRequest.action = action;

    Ranking ranking = this.rankContributionService.execute(rankingRequest);
    RankingView rankingView = new RankingView(ranking);

    response.json(rankingView);
  }

  private class RequestBody {
    public String userId;
  }
}
