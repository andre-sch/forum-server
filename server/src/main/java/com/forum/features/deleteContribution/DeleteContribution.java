package com.forum.features.deleteContribution;

import com.forum.entities.Contribution;
import com.forum.http.HttpHandler;
import com.forum.repositories.Repository;

public class DeleteContribution {
  public DeleteContribution(Repository<Contribution> contributionsRepository) {
    DeleteContributionService service = new DeleteContributionService(contributionsRepository);
    DeleteContributionController controller = new DeleteContributionController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
