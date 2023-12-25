package com.forum.features.createComment;

import com.forum.entities.Comment;
import com.forum.entities.User;
import com.forum.entities.Post;

import com.forum.repositories.CommentsRepository;
import com.forum.repositories.UsersRepository;
import com.forum.repositories.PostsRepository;

class CreateCommentService {
  private CommentsRepository commentsRepository;
  private UsersRepository usersRepository;
  private PostsRepository postsRepository;

  public CreateCommentService(
    CommentsRepository commentsRepository,
    UsersRepository usersRepository,
    PostsRepository postsRepository
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

    this.commentsRepository.create(comment);

    return comment;
  }
}
