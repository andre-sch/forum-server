package com.forum.entities;

import java.util.List;
import java.util.LinkedList;

public class Rank {
  private List<String> upVotes;
  private List<String> downVotes;

  public Rank() {
    this.upVotes = new LinkedList<>();
    this.downVotes = new LinkedList<>();
  }

  public List<String> upVotes() { return this.upVotes; }
  public List<String> downVotes() { return this.downVotes; }

  public void vote(String userId, String vote) {
    List<String> votingFor = vote.equals("upvote") ? this.upVotes : this.downVotes;
    List<String> votingAgainst = vote.equals("upvote") ? this.downVotes : this.upVotes;

    if (votingFor.contains(userId)) {
      throw new Error("cannot vote twice");
    }

    if (votingAgainst.contains(userId)) {
      votingAgainst.remove(userId);
    }

    votingFor.add(userId);
  }
}
