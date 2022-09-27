package ea.project.gatewayservice.service.impl;

import ea.project.gatewayservice.client.CommentsClient;
import ea.project.gatewayservice.domain.Comment;
import ea.project.gatewayservice.domain.CommentDto;
import ea.project.gatewayservice.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentsClient commentsClient;

    public CommentServiceImpl(CommentsClient commentsClient) {
        this.commentsClient = commentsClient;
    }


    @Override
    public List<Comment> getPostComments(Long postId) {
        return commentsClient.getPostComments(postId);
    }

    @Override
    public Comment updateComment(Long commentId, CommentDto commentDto) {
        return commentsClient.updateComment(commentId, commentDto);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentsClient.deleteComment(commentId);
    }

    @Override
    public void addComment(CommentDto commentDto) {
        commentsClient.addComment(commentDto);
    }
}
