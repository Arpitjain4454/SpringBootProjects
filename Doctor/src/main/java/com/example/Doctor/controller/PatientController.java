package com.example.Doctor.controller;

import com.example.Doctor.model.Doctor;
import com.example.Doctor.model.Patient;
import com.example.Doctor.respository.DoctorRepository;
import com.example.Doctor.service.PatientService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;
    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping(value = "/patient")
    public String savePatient(@RequestBody String patientRequest){
        JSONObject json = new JSONObject(patientRequest);
        Patient patient = setPatient(json);
        patientService.savePatient(patient);
        return "saved patient";
    }

    private Patient setPatient(JSONObject json) {

        Patient patient = new Patient();
        String patientId = json.getString("patientId");
        patient.setPatientId(Integer.valueOf(patientId));

        String patientName = json.getString("patientName");
        patient.setPatientName(patientName);

        Integer age = json.getInt("age");
        patient.setAge(age);

        String phoneNumber = json.getString("phoneNumber");
        patient.setAge(Integer.valueOf(phoneNumber));

        String diseaseType = json.getString("DiseaseType");
        patient.setAge(Integer.valueOf(diseaseType));

        String gender = json.getString("gender");
        patient.setAge(Integer.valueOf(gender));

       Timestamp currTime = new Timestamp(System.currentTimeMillis());
       patient.setAdmitTime(currTime);

       String doctorId = json.getString("doctorId");
       Doctor doctor = doctorRepository.findById(Integer.valueOf(doctorId)).get();
       patient.setDoctorId(doctor);

        return patient;
    }
}
