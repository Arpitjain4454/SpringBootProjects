package com.example.ecommerce.ecommerce.repository;

import com.example.ecommerce.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
