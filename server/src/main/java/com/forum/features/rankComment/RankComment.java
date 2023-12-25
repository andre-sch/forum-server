package com.forum.features.rankComment;

import com.forum.http.HttpHandler;
import com.forum.repositories.CommentsRepository;

public class RankComment {
  public RankComment(String vote, CommentsRepository commentsRepository) {
    RankCommentService service = new RankCommentService(commentsRepository);
    RankCommentController controller = new RankCommentController(vote, service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
