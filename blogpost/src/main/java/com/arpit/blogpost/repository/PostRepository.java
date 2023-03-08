package com.arpit.blogpost.repository;

import com.arpit.blogpost.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
