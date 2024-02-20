package com.forum.features.rankContribution;

import com.forum.http.HttpEndpointHandler;
import com.forum.repositories.Repository;
import com.forum.entities.*;

public class RankContribution {
  public RankContribution(
    Repository<User> usersRepository,
    Repository<Contribution> contributionsRepository,
    Repository<Ranking> rankingsRepository
  ) {
    RankContributionService service = new RankContributionService(
      usersRepository,
      contributionsRepository,
      rankingsRepository
    );

    RankContributionController controller = new RankContributionController(service);

    this.handler = controller;
  }

  public HttpEndpointHandler handler;
}
