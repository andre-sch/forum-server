package com.forum.features.rankComment;

import com.forum.entities.Comment;
import com.forum.repositories.Repository;

class RankCommentService {
  private Repository<Comment> commentsRepository;

  public RankCommentService(Repository<Comment> commentsRepository) {
    this.commentsRepository = commentsRepository;
  }

  public Comment execute(CommentRankingRequest rankingRequest) {
    Comment comment = this.commentsRepository.listOne(rankingRequest.commentId);

    if (comment == null) {
      throw new Error("Comment does not exist");
    }

    // comment.rank.vote(rankingRequest.userId, rankingRequest.vote);

    this.commentsRepository.update(comment);

    return comment;
  }
}
