package com.forum.features.createComment;

import com.forum.entities.*;
import com.forum.repositories.*;

class CreateCommentService {
  private Repository<Comment> commentsRepository;
  private Repository<User> usersRepository;
  private Repository<Post> postsRepository;

  public CreateCommentService(
    Repository<Comment> commentsRepository,
    Repository<User> usersRepository,
    Repository<Post> postsRepository
  ) {
    this.commentsRepository = commentsRepository;
    this.usersRepository = usersRepository;
    this.postsRepository = postsRepository;
  }

  public Comment execute(CommentCreationRequest creationRequest) {
    User author = this.usersRepository.listOne(creationRequest.authorId);

    if (author == null) {
      throw new Error("author does not exist");
    }

    Contribution parent = this.commentsRepository.listOne(creationRequest.parentId);

    if (parent == null) {
      parent = this.postsRepository.listOne(creationRequest.parentId);

      if (parent == null) {
        throw new Error("comment has no parent");
      }
    }

    Comment comment = new Comment();
    comment.setAuthor(author);
    comment.setParent(parent);
    comment.setContent(creationRequest.content);

    this.commentsRepository.save(comment);

    return comment;
  }
}
