package com.arpit.springdatajpatutorial.repository;

import com.arpit.springdatajpatutorial.entity.Guardian;
import com.arpit.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void saveStudentWithGuardianDetails(){

        Guardian guardian = Guardian.builder()
                .name("Seema Losar")
                .email("seemalosar@gmail.com")
                .phoneNumber("7744558845")
                .build();

        Student student = Student.builder()
                .firstName("Krishna")
                .emailId("krishna@gmail.com")
                .lastName("losar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Arpit");
        System.out.println("students = " + students);
    }

    @Test
    public void findByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("arp");
        System.out.println("students = " + students);
    }

    @Test
    public void findByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Ashish Losar");
            System.out.println("students =" + students);
    }

    @Test
    public void printgetStudentByEmailAddress(){
        String student = studentRepository.getStudentFirstNameByEmailAddress("arpitpjain47@gmail.com");
        System.out.println("student = " + student);
    }


    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

//    @Test
//    public void updateStudentNameByEmailIdTest(){
//        studentRepository.updateStudentNameByEmailId("Arpita","arpita@gmail.com");
//    }

}