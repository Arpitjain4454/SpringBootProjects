package com.arpit.springdatajpatutorial.repository;

import com.arpit.springdatajpatutorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
