package com.example.Doctor.respository;

import com.example.Doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
