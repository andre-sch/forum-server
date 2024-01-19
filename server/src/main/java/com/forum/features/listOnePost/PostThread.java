package com.forum.features.listOnePost;

import java.util.*;
import com.forum.entities.*;

class PostThread {
  public String id;
  public String title;
  public String content;
  public UserView author;
  public List<CategoryView> categories;
  public List<String> upVotes;
  public List<String> downVotes;
  public int createdAt;
  public int lastUpdate;
  public List<CommentNode> comments;

  public PostThread(Post post, List<CommentNode> comments) {
    this.id = post.getId();
    this.title = post.getTitle();
    this.content = post.getContent();

    this.author = new UserView(post.getAuthor());

    this.categories = post.getCategories()
      .stream().map(CategoryView::new).toList();

    this.upVotes = post.getUpVotes();
    this.downVotes = post.getDownVotes();

    this.createdAt = post.getCreationTimestamp();
    this.lastUpdate = post.getUpdateTimestamp();
    this.comments = comments;
  }
}

class CategoryView {
  public String name;
  public String description;

  public CategoryView(Category category) {
    this.name = category.getName();
    this.description = category.getDescription();
  }
}
