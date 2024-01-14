package com.forum.features.rankComment;

import com.forum.http.HttpHandler;
import com.forum.repositories.Repository;
import com.forum.entities.Comment;

public class RankComment {
  public RankComment(String vote, Repository<Comment> commentsRepository) {
    RankCommentService service = new RankCommentService(commentsRepository);
    RankCommentController controller = new RankCommentController(vote, service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
