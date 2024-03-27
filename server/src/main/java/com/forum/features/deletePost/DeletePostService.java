package com.forum.features.deletePost;

import java.util.Objects;
import com.forum.entities.Post;
import com.forum.repositories.PostsRepository;
import com.forum.exceptions.domain.RequestException;
import com.forum.exceptions.domain.RestrictedAccessException;

class DeletePostService {
  private PostsRepository postsRepository;

  public DeletePostService(PostsRepository postsRepository) {
    this.postsRepository = postsRepository;
  }

  public void execute(PostDeletionRequest deletionRequest) {
    Post post = this.postsRepository.listOne(deletionRequest.postId);

    if (post == null) {
      throw new RequestException("post does not exist");
    }

    if (
      !Objects.equals(
        post.getAuthorId(),
        deletionRequest.authenticatedUserId
      ) && !deletionRequest.isModerator
    ) {
      throw new RestrictedAccessException("cannot delete third-party posts");
    }

    post.setAuthor(null);
    post.setContent(null);

    this.postsRepository.update(post);
  }
}
