package com.forum.features.deleteContribution;

import com.forum.http.*;

class DeleteContributionController implements HttpEndpointHandler {
  private DeleteContributionService deleteContributionService;

  public DeleteContributionController(DeleteContributionService deleteContributionService) {
    this.deleteContributionService = deleteContributionService;
  }

  public void handle(HttpRequest request, HttpResponse response) {
    String authenticatedUserId = (String) request.getSessionAttribute("userId");

    String contributionId = request.getPathParam("contributionId");

    ContributionDeletionRequest deletionRequest = new ContributionDeletionRequest();

    deletionRequest.authenticatedUserId = authenticatedUserId;
    deletionRequest.contributionId = contributionId;

    this.deleteContributionService.execute(deletionRequest);

    response.status(204);
  }
}
