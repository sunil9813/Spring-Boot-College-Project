package com.bismdhr.bankmgmtsystem.service.impl;
import com.bismdhr.bankmgmtsystem.dto.PostUpdateDTO;
import com.bismdhr.bankmgmtsystem.exception.NotFoundException;
import com.bismdhr.bankmgmtsystem.model.Post;
import com.bismdhr.bankmgmtsystem.repository.PostRepository;
import com.bismdhr.bankmgmtsystem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(int id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.orElseThrow(() -> new NotFoundException("Post not found for id :"+id));
    }

    @Override
    public Post findByTitle(String title) {
        return null;
    }

    @Override
    public Post addPost(Post post) {
        return null;
    }

    @Override
    public Post updatePost(PostUpdateDTO postUpdateDTO) {
        Post post = findById(postUpdateDTO.getId());
        post.setTitle(postUpdateDTO.getTitle());
        post.setDescription(postUpdateDTO.getDescription());
        post.setAuthor(postUpdateDTO.getAuthor());
        post.setCategory(postUpdateDTO.getCategory());
        post.setDate(postUpdateDTO.getDate());
        return postRepository.save(post);
    }

    @Override
    public String deletePost(int id) {
        findById(id);
        postRepository.deleteById(id);
        return "Post deleted successfully";
    }

}
