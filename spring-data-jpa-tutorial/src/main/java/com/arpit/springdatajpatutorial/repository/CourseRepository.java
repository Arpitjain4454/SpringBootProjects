package com.arpit.springdatajpatutorial.repository;

import com.arpit.springdatajpatutorial.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long > {

    Page<Course> findByTitleContaining(String title, Pageable pageRequest);
}
