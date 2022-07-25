package com.bismdhr.bankmgmtsystem.repository;
import com.bismdhr.bankmgmtsystem.model.Post;
import com.bismdhr.bankmgmtsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Optional<Post> findByTitle(String title);
}


