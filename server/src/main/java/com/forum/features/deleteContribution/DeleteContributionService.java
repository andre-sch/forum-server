package com.forum.features.deleteContribution;

import com.forum.entities.Contribution;
import com.forum.repositories.Repository;

class DeleteContributionService {
  private Repository<Contribution> contributionsRepository;

  public DeleteContributionService(Repository<Contribution> contributionsRepository) {
    this.contributionsRepository = contributionsRepository;
  }

  public void execute(String contributionId) {
    Contribution contribution = this.contributionsRepository.listOne(contributionId);

    if (contribution == null) {
      throw new Error("contribution does not exist");
    }

    contribution.setAuthor(null);
    contribution.setContent(null);

    this.contributionsRepository.update(contribution);
  }
}
