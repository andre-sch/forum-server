package com.forum.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends Contribution {
  @ManyToOne
  @JoinColumn(name = "parent_id")
  private Contribution parent;

  private String content;

  public Comment() {}

  public Contribution getParent() { return this.parent; }
  public String getParentId() { return this.parent.getId(); }
  public String getContent() { return this.content; }

  public void setParent(Contribution parent) { this.parent = parent; }
  public void setContent(String content) { this.content = content; }
}
