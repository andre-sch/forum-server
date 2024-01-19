package com.forum.features.listOnePost;

import java.util.*;
import com.forum.entities.*;

class CommentNode {
  public String id;
  public String content;
  public UserView author;
  public List<String> upVotes;
  public List<String> downVotes;
  public int createdAt;
  public int lastUpdate;
  public List<CommentNode> replies;

  public CommentNode(Comment comment) {
    this.id = comment.getId();
    this.content = comment.getContent();
    this.author = new UserView(comment.getAuthor());
    this.upVotes = comment.getUpVotes();
    this.downVotes = comment.getDownVotes();
    this.createdAt = comment.getCreationTimestamp();
    this.lastUpdate = comment.getUpdateTimestamp();
    this.replies = new LinkedList<>();
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
