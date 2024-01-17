package com.forum.features.createComment;

import com.forum.entities.*;

class CommentView {
  public String id;
  public String parentId;
  public String content;
  public UserView author;
  public int createdAt;
  public int lastUpdate;

  public CommentView(Comment comment) {
    this.id = comment.getId();
    this.content = comment.getContent();
    this.parentId = comment.getParentId();
    this.author = new UserView(comment.getAuthor());
    this.createdAt = comment.getCreationTimestamp();
    this.lastUpdate = comment.getUpdateTimestamp();
  }
}

class UserView {
  public String id;
  public String name;
  public String email;
  public String avatarUrl;

  public UserView(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.avatarUrl = user.getAvatarUrl();
  }
}
