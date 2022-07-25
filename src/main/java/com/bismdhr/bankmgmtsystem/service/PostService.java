package com.bismdhr.bankmgmtsystem.service;
import com.bismdhr.bankmgmtsystem.dto.PostUpdateDTO;
import com.bismdhr.bankmgmtsystem.model.Post;
import java.util.List;

public interface PostService {
    List<Post> getAllPost();

    Post findById(int id);

    Post findByTitle(String title);

    Post addPost(Post post);

    Post updatePost(PostUpdateDTO post);

    String deletePost(int id);
}
