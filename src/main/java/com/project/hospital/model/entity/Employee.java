package com.project.hospital.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "id_employee")
    private Integer id;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "second_name")
    private String secondName;

    @ManyToOne (cascade = {CascadeType.REFRESH,CascadeType.PERSIST,
            CascadeType.MERGE,CascadeType.DETACH}) //подумаnm, может сделать uni-directional связь
    @JoinColumn (name = "department")
    private Department department;


    @ManyToMany (cascade = {CascadeType.REFRESH,CascadeType.PERSIST,
            CascadeType.MERGE,CascadeType.DETACH},  fetch = FetchType.LAZY, targetEntity = Patient.class)
    @JoinTable (name = "therapy",
            joinColumns ={@JoinColumn(name = "id_employee")},
            inverseJoinColumns = {@JoinColumn(name = "id_patient")})
    private List <Patient> patients;


    public Employee() {
    }

    public Employee(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public void addPatientToEmployee (Patient patient) {
        if (patients == null){
            patients = new ArrayList<>();
        }
        patients.add(patient);
    }

    @Override
    public String toString() {
        return firstName + " "+ secondName;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


}