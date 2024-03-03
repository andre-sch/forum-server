package com.forum.features.updateComment;

import com.forum.entities.Comment;
import com.forum.repositories.CommentsRepository;
import com.forum.exceptions.domain.RequestException;

class UpdateCommentService {
  private CommentsRepository commentsRepository;

  public UpdateCommentService(CommentsRepository commentsRepository) {
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
