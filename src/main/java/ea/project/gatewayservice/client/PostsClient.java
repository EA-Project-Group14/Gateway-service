package ea.project.gatewayservice.client;

import ea.project.gatewayservice.domain.PostRequest;
import ea.project.gatewayservice.domain.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "posts-service")
public interface PostsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    public List<PostResponse> getAll();

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    public List<PostResponse> getUserPosts(@RequestParam Long userId);

    @RequestMapping(method = RequestMethod.POST, value = "/posts")
    public void savePost(@RequestBody PostRequest postRequest);

    @RequestMapping(method = RequestMethod.DELETE, value = "/posts/{postId}")
    public void deletePost(@PathVariable Long postId);

    @RequestMapping(method = RequestMethod.PUT, value = "/posts/{postId}")
    public PostResponse updatePost(@PathVariable Long postId, @RequestBody PostRequest postRequest);

}
