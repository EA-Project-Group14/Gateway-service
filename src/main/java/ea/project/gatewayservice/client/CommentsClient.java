package ea.project.gatewayservice.client;

import ea.project.gatewayservice.domain.Comment;
import ea.project.gatewayservice.domain.CommentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "comments-service")
public interface CommentsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/comments")
    List<Comment> getPostComments(@RequestParam Long postId);

    @RequestMapping(method = RequestMethod.PUT,value = "/comments/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentDto commentDto);

    @RequestMapping(method = RequestMethod.DELETE,value = "/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId);

    @RequestMapping(method = RequestMethod.POST,value ="/comments")
    public void addComment(@RequestBody CommentDto commentDto);

}
