package com.arpit.springdatajpatutorial.repository;

import com.arpit.springdatajpatutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.beans.Transient;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByLastNameNotNull();
    public List<Student> findByGuardianName(String guardianName);

    //JPQL Query
    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailAddress(String emailId);



//    @Modifying
//    @Transactional
//    @Query(
//            value = "update tbl_student set first_name = ?1 where email_id = ?2",
//            nativeQuery = true
//    )
//    public int updateStudentNameByEmailId(String firstName, String emailId);
}
