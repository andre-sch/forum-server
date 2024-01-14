package com.forum.features.listOnePost;

import java.util.List;
import com.forum.entities.Post;
import com.forum.repositories.Repository;

class ListOnePostService {
  private Repository<Post> postsRepository;
  private ListPostCommentsService listPostCommentsService;

  public ListOnePostService(
    Repository<Post> postsRepository,
    ListPostCommentsService listPostCommentsService
  ) {
    this.postsRepository = postsRepository;
    this.listPostCommentsService = listPostCommentsService;
  }

  public PostThread execute(String postId) {
    Post post = this.postsRepository.listOne(postId);

    List<CommentNode> comments = this.listPostCommentsService.execute(postId);

    return new PostThread(post, comments);
  }
}
