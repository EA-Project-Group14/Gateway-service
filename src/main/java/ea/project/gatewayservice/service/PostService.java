package ea.project.gatewayservice.service;

import ea.project.gatewayservice.domain.PostRequest;
import ea.project.gatewayservice.domain.PostResponse;

import java.util.List;

public interface PostService {

    List<PostResponse> getAll();

    List<PostResponse> getUserPosts(Long userId);

    void savePost(PostRequest postRequest);

    void deletePost(Long postId);

    PostResponse updatePost(Long postId, PostRequest postRequest);
}
