package com.forum.entities;

import java.util.UUID;
import com.forum.utils.Time;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "contributions")
public class Contribution {
  @Id
  private String id;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private User author;

  // private Rank rank;

  private int createdAt;
  private int lastUpdate;

  public Contribution() {
    UUID uuid = UUID.randomUUID();
    this.id = uuid.toString();

    this.createdAt = Time.now();
    this.lastUpdate = this.createdAt;
  }

  public String getId() { return this.id; }
  public String getAuthorId() { return this.author.getId(); }
  public User getAuthor() { return this.author; }
  public int getCreationTimestamp() { return this.createdAt; }
  public int getUpdateTimestamp() { return this.lastUpdate; }

  public void setAuthor(User author) { this.author = author; }
}
