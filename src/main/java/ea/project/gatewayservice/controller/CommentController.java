package ea.project.gatewayservice.controller;

import ea.project.gatewayservice.domain.Comment;
import ea.project.gatewayservice.domain.CommentDto;
import ea.project.gatewayservice.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(params = "postId")
    List<Comment> getPostComments(@RequestParam Long postId){
        return commentService.getPostComments(postId);
    }

    @PutMapping( "/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentDto commentDto){
        return commentService.updateComment(commentId, commentDto);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }

    @PostMapping
    public void addComment(@RequestBody CommentDto commentDto){
        commentService.addComment(commentDto);
    }
}
