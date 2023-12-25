package com.forum.features.rankPost;

import com.forum.entities.Post;
import com.forum.repositories.PostsRepository;

class RankPostService {
  private PostsRepository postsRepository;

  public RankPostService(PostsRepository postsRepository) {
    this.postsRepository = postsRepository;
  }

  public Post execute(PostRankingRequest rankingRequest) {
    Post post = this.postsRepository.listOne(rankingRequest.postId);

    if (post == null) {
      throw new Error("post does not exist");
    }

    post.rank.vote(rankingRequest.userId, rankingRequest.vote);

    this.postsRepository.update(post);

    return post;
  }
}
