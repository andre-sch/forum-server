package com.forum.entities;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post extends Contribution {
  private String title;
  private String content;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "post_categories",
    joinColumns = @JoinColumn(name = "post_id"),
    inverseJoinColumns = @JoinColumn(name = "category_name")
  )
  private Set<Category> categories;

  public Post() {}

  public String getTitle() { return this.title; }
  public String getContent() { return this.content; }
  public Set<Category> getCategories() { return this.categories; }
  public Set<String> getCategoryNames() {
    Set<String> categoryNames = new HashSet<>();
    this.getCategories().forEach((category) -> categoryNames.add(category.getName()));
    return categoryNames;
  }

  public void setTitle(String title) { this.title = title; }
  public void setContent(String content) { this.content = content; }
  public void setCategories(Set<Category> categories) { this.categories = categories; }
}
