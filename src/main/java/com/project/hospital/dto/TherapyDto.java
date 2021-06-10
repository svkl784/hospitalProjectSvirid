package com.project.hospital.dto;

import com.project.hospital.model.entity.Employee;
import com.project.hospital.model.entity.Patient;

import javax.persistence.*;

public class TherapyDto {
    private Integer id_therapy;
    private int id_category_therapy;
    private String name_therapy;

    private Patient id_patient;

    private Employee id_employee;

    public Integer getId_therapy() {
        return id_therapy;
    }

    public void setId_therapy(Integer id_therapy) {
        this.id_therapy = id_therapy;
    }

    public int getId_category_therapy() {
        return id_category_therapy;
    }

    public void setId_category_therapy(int id_category_therapy) {
        this.id_category_therapy = id_category_therapy;
    }

    public String getName_therapy() {
        return name_therapy;
    }

    public void setName_therapy(String name_therapy) {
        this.name_therapy = name_therapy;
    }

    public Patient getId_patient() {
        return id_patient;
    }

    public void setId_patient(Patient id_patient) {
        this.id_patient = id_patient;
    }

    public Employee getId_employee() {
        return id_employee;
    }

    public void setId_employee(Employee id_employee) {
        this.id_employee = id_employee;
    }
}
