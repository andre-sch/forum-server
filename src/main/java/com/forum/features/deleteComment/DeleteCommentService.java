package com.forum.features.deleteComment;

import java.util.Objects;
import com.forum.entities.Comment;
import com.forum.repositories.CommentsRepository;
import com.forum.exceptions.domain.RequestException;
import com.forum.exceptions.domain.RestrictedAccessException;

class DeleteCommentService {
  private CommentsRepository commentsRepository;

  public DeleteCommentService(CommentsRepository commentsRepository) {
    this.commentsRepository = commentsRepository;
  }

  public void execute(CommentDeletionRequest deletionRequest) {
    Comment comment = this.commentsRepository.listOne(deletionRequest.commentId);

    if (comment == null) {
      throw new RequestException("comment does not exist");
    }

    boolean isCommentOwner = Objects.equals(comment.getAuthorId(), deletionRequest.authenticatedUserId);
    if (!isCommentOwner && !deletionRequest.isAuthoritative) {
      throw new RestrictedAccessException("cannot delete third-party comments");
    }

    comment.setAuthor(null);
    comment.setContent(null);

    this.commentsRepository.update(comment);
  }
}
