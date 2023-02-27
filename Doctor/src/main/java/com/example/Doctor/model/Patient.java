package com.example.Doctor.model;
import jakarta.persistence.*;

import java.sql.Timestamp;

public class Patient {
    @Id
    @Column(name="patient_Id")
    private Integer patientId;
    @Column(name = "patient_Name")
    private  String patientName;
    @Column(name = "patient_Age")
    private Integer age;
    @Column(name = "phone_Number")
    private String phoneNumber;
    @Column(name = "Disease_Type")
    private String diseaseType;
    @Column(name = "gender")
    private String gender;

    @Column(name = "admit_date")
    private Timestamp admitTime;
    @JoinColumn(name = "doctor_Id")
    @ManyToOne
    private Doctor doctorId;

    public Patient(Integer patientId, String patientName, Integer age, String phoneNumber, String diseaseType, String gender, Timestamp admitTime, Doctor doctorId) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.diseaseType = diseaseType;
        this.gender = gender;
        this.admitTime = admitTime;
        this.doctorId = doctorId;
    }

    public Patient() {
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Timestamp getAdmitTime() {
        return admitTime;
    }

    public void setAdmitTime(Timestamp admitTime) {
        this.admitTime = admitTime;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", DiseaseType='" + diseaseType + '\'' +
                ", gender='" + gender + '\'' +
                ", admitTime=" + admitTime +
                ", doctorId=" + doctorId +
                '}';
    }
}
