package ea.project.gatewayservice.controller;

import ea.project.gatewayservice.domain.PostRequest;
import ea.project.gatewayservice.domain.PostResponse;
import ea.project.gatewayservice.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostResponse> getAll() {
        return postService.getAll();
    }

    @GetMapping(params = "userId")
    public List<PostResponse> getUserPosts(Long userId) {
        return postService.getUserPosts(userId);
    }

    @PostMapping
    public void savePost(@RequestBody PostRequest postRequest) {
        postService.savePost(postRequest);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }

    @PutMapping("/{postId}")
    public PostResponse updatePost(@PathVariable Long postId, @RequestBody PostRequest postRequest) {
        return postService.updatePost(postId, postRequest);
    }

}
