package com.forum.features.updateComment;

import com.forum.entities.Comment;
import com.forum.repositories.Repository;
import com.forum.exceptions.domain.RequestException;

class UpdateCommentService {
  private Repository<Comment> commentsRepository;

  public UpdateCommentService(Repository<Comment> commentsRepository) {
    this.commentsRepository = commentsRepository;
  }

  public Comment execute(CommentUpdateRequest updateRequest) {
    Comment comment = this.commentsRepository.listOne(updateRequest.commentId);

    if (comment == null) {
      throw new RequestException("comment does not exist");
    }

    if (updateRequest.content != null) {
      comment.setContent(updateRequest.content);
    }

    this.commentsRepository.update(comment);

    return comment;
  }
}
