package com.arpit.springdatajpatutorial.repository;

import com.arpit.springdatajpatutorial.entity.Course;
import com.arpit.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseSQL = Course.builder()
                .title("SQL")
                .credit(3)
                .build();

        Course courseOOPS = Course.builder()
                .title("OOPS")
                .credit(8)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Isha")
                .lastName("Jain")
                //.courses(List.of(courseDBA, courseSQL, courseOOPS))
                .build();

        teacherRepository.save(teacher);
    }
}