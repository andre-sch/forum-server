package com.forum.features.updateComment;

import com.forum.repositories.Repository;
import com.forum.entities.Comment;

class UpdateCommentService {
  private Repository<Comment> commentsRepository;

  public UpdateCommentService(Repository<Comment> commentsRepository) {
    this.commentsRepository = commentsRepository;
  }

  public Comment execute(CommentUpdateRequest updateRequest) {
    Comment comment = this.commentsRepository.listOne(updateRequest.commentId);

    if (comment == null) {
      throw new Error("comment does not exist");
    }

    if (updateRequest.content != null) {
      comment.setContent(updateRequest.content);
    }

    this.commentsRepository.update(comment);

    return comment;
  }
}
