package com.arpit.springdatajpatutorial.repository;

import com.arpit.springdatajpatutorial.entity.Course;
import com.arpit.springdatajpatutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepositoryrepository;

    @Test
    public void SaveCourseMaterial(){

        Course course = Course.builder()
                .title(".net")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.arpit.com")
                .course(course)
                .build();

        courseMaterialRepositoryrepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepositoryrepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }
}