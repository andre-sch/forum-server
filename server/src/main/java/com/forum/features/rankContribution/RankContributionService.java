package com.forum.features.rankContribution;

import com.forum.entities.*;
import com.forum.repositories.Repository;

class RankContributionService {
  private Repository<User> usersRepository;
  private Repository<Contribution> contributionsRepository;
  private Repository<Ranking> rankingsRepository;

  public RankContributionService(
    Repository<User> usersRepository,
    Repository<Contribution> contributionsRepository,
    Repository<Ranking> rankingsRepository
  ) {
    this.usersRepository = usersRepository;
    this.contributionsRepository = contributionsRepository;
    this.rankingsRepository = rankingsRepository;
  }

  public Ranking execute(ContributionRankingRequest rankingRequest) {
    User user = this.usersRepository.listOne(rankingRequest.userId);

    if (user == null) {
      throw new Error("user does not exist");
    }

    Contribution contribution = this.contributionsRepository.listOne(rankingRequest.contributionId);

    if (contribution == null) {
      throw new Error("contribution does not exist");
    }

    Ranking ranking = new Ranking();
    ranking.setId(user, contribution);
    ranking.setVote(rankingRequest.action);

    this.rankingsRepository.update(ranking);

    return ranking;
  }
}
