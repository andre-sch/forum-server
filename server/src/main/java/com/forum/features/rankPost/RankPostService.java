package com.forum.features.rankPost;

import com.forum.entities.Post;
import com.forum.repositories.Repository;

class RankPostService {
  private Repository<Post> postsRepository;

  public RankPostService(Repository<Post> postsRepository) {
    this.postsRepository = postsRepository;
  }

  public Post execute(PostRankingRequest rankingRequest) {
    Post post = this.postsRepository.listOne(rankingRequest.postId);

    if (post == null) {
      throw new Error("post does not exist");
    }

    // post.rank.vote(rankingRequest.userId, rankingRequest.vote);

    this.postsRepository.update(post);

    return post;
  }
}
