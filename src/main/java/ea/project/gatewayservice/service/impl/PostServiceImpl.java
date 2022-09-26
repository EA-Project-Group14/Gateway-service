package ea.project.gatewayservice.service.impl;

import ea.project.gatewayservice.client.PostsClient;
import ea.project.gatewayservice.domain.PostRequest;
import ea.project.gatewayservice.domain.PostResponse;
import ea.project.gatewayservice.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostsClient postsClient;

    public PostServiceImpl(PostsClient postsClient) {
        this.postsClient = postsClient;
    }

    @Override
    public List<PostResponse> getAll() {
        return postsClient.getAll();
    }

    @Override
    public List<PostResponse> getUserPosts(Long userId) {
        return postsClient.getUserPosts(userId);
    }

    @Override
    public void savePost(PostRequest postRequest) {
        postsClient.savePost(postRequest);
    }

    @Override
    public void deletePost(Long postId) {
        postsClient.deletePost(postId);
    }

    @Override
    public PostResponse updatePost(Long postId, PostRequest postRequest) {
        return postsClient.updatePost(postId, postRequest);
    }

}
