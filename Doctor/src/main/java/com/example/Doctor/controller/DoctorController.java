package com.example.Doctor.controller;

import com.example.Doctor.model.Doctor;
import com.example.Doctor.service.DoctorService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping(value ="/doctors")
    public ResponseEntity<String> saveDoctor(@RequestBody String requestdoctor){
        JSONObject json = new JSONObject(requestdoctor);

        List<String>validationList = validateDoctor(json);

        if(validationList.isEmpty()){
            Doctor doctor = setDoctor(json);
            doctorService.saveDoctor(doctor);
            return new ResponseEntity<>("Doctor saved", HttpStatus.CREATED);
        }
        else{
            String[] answer = Arrays.copyOf(validationList.toArray(), validationList.size(), String[].class);

            return new ResponseEntity<>("Please pass Mandatory parameters- " + Arrays.toString(answer), HttpStatus.BAD_REQUEST);
        }
    }

    private List<String> validateDoctor(JSONObject json) {

        List<String> errorList = new ArrayList<>();

        if(!json.has("doctorId")){
            errorList.add("doctorId");
        }

        if(!json.has("doctorName")){
            errorList.add("doctorName");
        }

        if(!json.has("specializedIn")){
            errorList.add("specializedIn");
        }
        return errorList;
    }

    private Doctor setDoctor(JSONObject json) {
        Doctor doctor = new Doctor();
        String doctorId = json.getString("doctorId");
        doctor.setDoctorId(Integer.valueOf(doctorId));

        String doctorName = json.getString("doctorName");
        doctor.setDoctorName(doctorName);

        String specializedIn = json.getString("specializedIn");
        doctor.setSpecializedIn(specializedIn);

        if(json.has("experience")){
            String experience = json.getString("experience");
            doctor.setExperience(experience);
        }

        return doctor;

    }

    @GetMapping(value = "/doctors")
    public List<Doctor> fetchDoctorstList(@Nullable @RequestParam Long doctorId, @RequestParam String experience){
        return doctorService.fetchDoctorsList(doctorId, experience);

    }

}
