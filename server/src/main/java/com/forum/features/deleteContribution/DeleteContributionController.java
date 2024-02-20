package com.forum.features.deleteContribution;

import com.forum.http.*;

class DeleteContributionController implements HttpEndpointHandler {
  private DeleteContributionService deleteContributionService;

  public DeleteContributionController(DeleteContributionService deleteContributionService) {
    this.deleteContributionService = deleteContributionService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String contributionId = request.getPathParam("contributionId");

    this.deleteContributionService.execute(contributionId);

    response.status(204);
  }
}
