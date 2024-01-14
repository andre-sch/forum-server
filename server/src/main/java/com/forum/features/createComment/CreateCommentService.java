package com.forum.features.createComment;

import com.forum.entities.Comment;
import com.forum.entities.User;
import com.forum.entities.Post;

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
    User author = this.usersRepository.listOne(creationRequest.author);

    if (author == null) {
      throw new Error("author does not exist");
    }

    Comment comment = this.commentsRepository.listOne(creationRequest.parentId);

    if (comment == null) {
      Post post = this.postsRepository.listOne(creationRequest.parentId);

      if (post == null) {
        throw new Error("comment has no parent");
      }
    }

    comment = new Comment(
      creationRequest.parentId,
      creationRequest.author,
      creationRequest.content
    );

    this.commentsRepository.save(comment);

    return comment;
  }
}
