package com.example.Doctor.service;

import com.example.Doctor.model.Doctor;
import com.example.Doctor.respository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService{

    @Autowired
    DoctorRepository doctorRepository;


    public Doctor saveDoctor(Doctor doctor){
        String doctorName = doctor.getDoctorName();
        doctorName= "Dr. " +  doctorName;
        doctor.setDoctorName((doctorName));
        return doctorRepository.save(doctor);
    }

    public List<Doctor> fetchDoctorsList(Long doctorId, String experienced ) {

        List<Doctor> doctorList;

        if(null!=doctorId){
            doctorList = new ArrayList<>();
            doctorList.add(doctorRepository.findById(Math.toIntExact(doctorId)).get());
        }
        else{
            doctorList = doctorRepository.findAll();
        }
        return doctorList;
    }
}
