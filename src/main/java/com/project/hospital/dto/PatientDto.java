package com.project.hospital.dto;

import com.project.hospital.model.entity.Employee;
import com.project.hospital.model.entity.Therapy;

import javax.persistence.*;
import java.util.List;

public class PatientDto {
    private Long id_patient;
    private String firstName;
    private String secondName;
    private String dateOfBirth;
    private String healthsComplaints;

    private Therapy therapy;

    private List<Employee> employees;

    public Long getId_patient() {
        return id_patient;
    }

    public void setId_patient(Long id_patient) {
        this.id_patient = id_patient;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHealthsComplaints() {
        return healthsComplaints;
    }

    public void setHealthsComplaints(String healthsComplaints) {
        this.healthsComplaints = healthsComplaints;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
