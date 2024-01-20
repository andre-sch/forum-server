package com.forum.views;

import java.util.List;
import com.forum.entities.Post;

public class CompactPostView {
  public String id;
  public String title;
  public String content;
  public CompactUserView author;
  public List<CompactCategoryView> categories;
  public int createdAt;
  public int lastUpdate;

  public CompactPostView(Post post) {
    this.id = post.getId();
    this.title = post.getTitle();
    this.content = post.getContent();

    this.author = new CompactUserView(post.getAuthor());

    this.categories = post.getCategories()
      .stream().map(CompactCategoryView::new).toList();

    this.createdAt = post.getCreationTimestamp();
    this.lastUpdate = post.getUpdateTimestamp();
  }
}
