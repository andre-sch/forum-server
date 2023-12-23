package com.forum.features.listPostComments;

import java.util.List;
import java.util.LinkedList;
import com.forum.entities.Comment;

class CommentNode {
  public String id;
  public String content;
  public String author;
  public long createdAt;
  public long lastUpdate;
  public List<CommentNode> replies;

  public CommentNode(Comment comment) {
    this.id = comment.id;
    this.content = comment.content;
    this.author = comment.author;
    this.createdAt = comment.createdAt;
    this.lastUpdate = comment.lastUpdate;
    this.replies = new LinkedList<>();
  }
}
