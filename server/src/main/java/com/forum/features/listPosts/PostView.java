package com.forum.features.listPosts;

import java.util.List;
import com.forum.entities.*;

class PostView {
  public String id;
  public String title;
  public String content;
  public UserView author;
  public List<CategoryView> categories;
  public int createdAt;
  public int lastUpdate;

  public PostView(Post post) {
    this.id = post.getId();
    this.title = post.getTitle();
    this.content = post.getContent();

    this.author = new UserView(post.getAuthor());

    this.categories = post.getCategories()
      .stream().map(CategoryView::new).toList();

    this.createdAt = post.getCreationTimestamp();
    this.lastUpdate = post.getUpdateTimestamp();
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

class CategoryView {
  public String name;
  public String description;

  public CategoryView(Category category) {
    this.name = category.getName();
    this.description = category.getDescription();
  }
}
