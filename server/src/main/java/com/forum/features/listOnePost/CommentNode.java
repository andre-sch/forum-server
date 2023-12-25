package com.forum.features.listOnePost;

import java.util.List;
import java.util.LinkedList;
import com.forum.entities.Comment;
import com.forum.entities.Rank;

class CommentNode {
  public String id;
  public String author;
  public String content;
  public Rank rank;
  public long createdAt;
  public long lastUpdate;
  public List<CommentNode> replies;

  public CommentNode(Comment comment) {
    this.id = comment.id;
    this.author = comment.author;
    this.content = comment.content;
    this.rank = comment.rank;
    this.createdAt = comment.createdAt;
    this.lastUpdate = comment.lastUpdate;
    this.replies = new LinkedList<>();
  }
}
