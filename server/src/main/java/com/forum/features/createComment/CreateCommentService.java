package com.forum.features.createComment;

import com.forum.entities.*;
import com.forum.repositories.*;
import com.forum.exceptions.domain.RequestException;

class CreateCommentService {
  private Repository<Contribution> contributionsRepository;
  private Repository<Comment> commentsRepository;
  private Repository<User> usersRepository;

  public CreateCommentService(
    Repository<Contribution> contributionsRepository,
    Repository<Comment> commentsRepository,
    Repository<User> usersRepository
  ) {
    this.contributionsRepository = contributionsRepository;
    this.commentsRepository = commentsRepository;
    this.usersRepository = usersRepository;
  }

  public Comment execute(CommentCreationRequest creationRequest) {
    User author = this.usersRepository.listOne(creationRequest.authorId);

    if (author == null) {
      throw new RequestException("author does not exist");
    }

    Contribution parent = this.contributionsRepository.listOne(creationRequest.parentId);

    if (parent == null) {
      throw new RequestException("comment has no parent");
    }

    Comment comment = new Comment();
    comment.setAuthor(author);
    comment.setParent(parent);
    comment.setContent(creationRequest.content);

    this.commentsRepository.save(comment);

    return comment;
  }
}
