package com.arpit.studentPortal.service;

import com.arpit.studentPortal.model.Student;
import com.arpit.studentPortal.repository.StudentRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student" + "id"));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudentById(String id, Student student) {
        Student existingStudent = getStudentById(id);
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setPhoneNumber(student.getPhoneNumber());
        existingStudent.setBranch(student.getBranch());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setAddress(student.getAddress());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudentById(String id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}
