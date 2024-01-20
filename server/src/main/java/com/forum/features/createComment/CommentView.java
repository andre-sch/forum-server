package com.forum.features.createComment;

import com.forum.entities.*;
import com.forum.views.CompactUserView;

class CommentView {
  public String id;
  public String parentId;
  public String content;
  public CompactUserView author;
  public int createdAt;
  public int lastUpdate;

  public CommentView(Comment comment) {
    this.id = comment.getId();
    this.content = comment.getContent();
    this.parentId = comment.getParentId();
    this.author = new CompactUserView(comment.getAuthor());
    this.createdAt = comment.getCreationTimestamp();
    this.lastUpdate = comment.getUpdateTimestamp();
  }
}
