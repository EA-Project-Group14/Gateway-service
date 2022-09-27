package ea.project.gatewayservice.service;

import ea.project.gatewayservice.domain.Comment;
import ea.project.gatewayservice.domain.CommentDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CommentService {

    List<Comment> getPostComments(Long postId);


    Comment updateComment(Long commentId, CommentDto commentDto);


    void deleteComment(Long commentId);


    void addComment(CommentDto commentDto);
}
