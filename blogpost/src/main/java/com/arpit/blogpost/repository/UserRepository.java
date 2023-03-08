package com.arpit.blogpost.repository;

import com.arpit.blogpost.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
