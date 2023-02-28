package com.arpit.springdatajpatutorial.repository;

import com.arpit.springdatajpatutorial.entity.Course;
import com.arpit.springdatajpatutorial.entity.Guardian;
import com.arpit.springdatajpatutorial.entity.Student;
import com.arpit.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse(){
        
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);

    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Ria")
                .lastName("Jain")
                .build();

        Course course = Course.builder()
                .title("Java")
                .credit(10)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        PageRequest firstPageWithThreeRecords = 
                PageRequest.of(0, 3);
        
        PageRequest secongPageWithThreeRecords = 
                PageRequest.of(1, 2);
        
        List<Course> courses = (List<Course>) courseRepository.findAll(secongPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(secongPageWithThreeRecords).getTotalElements();
        long totalPages = courseRepository.findAll(secongPageWithThreeRecords).getTotalPages();

        System.out.println("courses = " + courses);
        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc =
                PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCredit =
                PageRequest.of(0, 2, Sort.by("title").descending()
                        .and(Sort.by("credit"))
                );

        List<Course> courses = (List<Course>) courseRepository.findAll(sortByTitleAndCredit).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void printfindByIdTitleContaining(){
        Pageable firstPageTenRecords = PageRequest.of(
                0, 10
        );

        List<Course> courses = (List<Course>) courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();
        System.out.println("courses = " + courses);
    }


    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Hannah")
                .lastName("Jain")
                .build();

        Guardian guardian = Guardian.builder()
                .name("Sattu Mali")
                .email("sattubhangi@gmail.com")
                .phoneNumber("7744558845")
                .build();

        Student student = Student.builder()
                .firstName("Hansraj")
                .emailId("Hansraj@gmail.com")
                .lastName("Bhangi")
                .guardian(guardian)
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(10)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);

    }

}