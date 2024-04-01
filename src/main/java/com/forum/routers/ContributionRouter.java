package com.forum.routers;

import com.forum.*;
import com.forum.http.*;
import com.forum.endpoints.*;
import com.forum.repositories.*;

import com.forum.features.rankContribution.*;

public class ContributionRouter implements Router {
  private HttpApp app;
  private RestrictedEndpointFactory restrictedEndpoint = new RestrictedEndpointFactory();

  private UsersRepository usersRepository = Repositories.getUsersRepository();
  private ContributionsRepository contributionsRepository = Repositories.getContributionsRepository();
  private RankingsRepository rankingsRepository = Repositories.getRankingsRepository();

  public ContributionRouter(HttpApp app) {
    this.app = app;
  }

  public void bindEndpoints() {
    this.app.put("/ranking/{contributionId}/{action}", restrictedEndpoint.create(
      new RankContribution(usersRepository, contributionsRepository, rankingsRepository).handler,
      "rank-contribution"
    ));
  }
}
