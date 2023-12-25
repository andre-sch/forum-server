package com.forum.features.listOnePost;

import java.util.List;
import com.forum.entities.Post;
import com.forum.entities.Rank;

class PostThread {
  public String id;
  public String author;
  public String title;
  public String content;
  public String[] categories;
  public Rank rank;
  public int createdAt;
  public int lastUpdate;
  public List<CommentNode> comments;

  public PostThread(Post post, List<CommentNode> comments) {
    this.id = post.id;
    this.author = post.author;
    this.title = post.title;
    this.content = post.content;
    this.categories = post.categories;
    this.rank = post.rank;
    this.createdAt = post.createdAt;
    this.lastUpdate = post.lastUpdate;
    this.comments = comments;
  }
}
