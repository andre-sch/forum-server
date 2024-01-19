package com.forum.features.listOnePost;

import java.util.*;
import com.forum.repositories.Repository;
import com.forum.entities.Comment;

class ListPostCommentsService {
  private Repository<Comment> commentsRepository;

  public ListPostCommentsService(Repository<Comment> commentsRepository) {
    this.commentsRepository = commentsRepository;
  }

  public List<CommentNode> execute(String postId) {
    List<Comment> rootComments = this.getRepliesFrom(postId);
    List<CommentNode> listOfComments = rootComments.stream().map(CommentNode::new).toList();
    this.populateCommentReplies(listOfComments);

    return listOfComments;
  }

  private void populateCommentReplies(List<CommentNode> listOfComments) {
    Queue<CommentNode> commentQueue = new LinkedList<>(listOfComments);

    while (commentQueue.size() > 0) {
      CommentNode commentNode = commentQueue.poll();

      List<Comment> replies = this.getRepliesFrom(commentNode.id);

      replies.forEach((Comment reply) -> {
        CommentNode replyNode = new CommentNode(reply);

        commentNode.replies.add(replyNode);
        commentQueue.offer(replyNode);
      });
    }
  }

  private List<Comment> getRepliesFrom(String id) {
    return this.commentsRepository.list((Comment comment) -> comment.getParentId().equals(id));
  }
}
