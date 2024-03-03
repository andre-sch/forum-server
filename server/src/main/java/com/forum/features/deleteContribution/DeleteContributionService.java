package com.forum.features.deleteContribution;

import com.forum.entities.Contribution;
import com.forum.repositories.ContributionsRepository;
import com.forum.exceptions.domain.RequestException;

class DeleteContributionService {
  private ContributionsRepository contributionsRepository;

  public DeleteContributionService(ContributionsRepository contributionsRepository) {
    this.contributionsRepository = contributionsRepository;
  }

  public void execute(String contributionId) {
    Contribution contribution = this.contributionsRepository.listOne(contributionId);

    if (contribution == null) {
      throw new RequestException("contribution does not exist");
    }

    contribution.setAuthor(null);
    contribution.setContent(null);

    this.contributionsRepository.update(contribution);
  }
}
