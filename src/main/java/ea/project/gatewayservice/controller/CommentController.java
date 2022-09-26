package ea.project.gatewayservice.controller;

import ea.project.gatewayservice.client.CommentsClient;
import ea.project.gatewayservice.domain.Comment;
import ea.project.gatewayservice.domain.CommentDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentsClient commentsClient;

    public CommentController(CommentsClient commentsClient) {
        this.commentsClient = commentsClient;
    }

    @GetMapping(params = "postId")
    List<Comment> getPostComments(@RequestParam Long postId){
        return commentsClient.getPostComments(postId);
    }

    @PutMapping( "/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentDto commentDto){
        return commentsClient.updateComment(commentId, commentDto);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentsClient.deleteComment(commentId);
    }

    @PostMapping
    public void addComment(@RequestBody CommentDto commentDto){
        commentsClient.addComment(commentDto);
    }
}
