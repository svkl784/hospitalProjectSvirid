package com.project.hospital.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private Long id_patient;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "health_complaints")
    private String healthsComplaints;

    @OneToOne(mappedBy = "id_patient",
            cascade = {CascadeType.REFRESH, CascadeType.PERSIST,
                    CascadeType.MERGE, CascadeType.DETACH})
    private Therapy therapy;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY,targetEntity= Employee.class)
    @JoinTable(name = "therapy",
            joinColumns = {@JoinColumn(name = "id_patient")},
            inverseJoinColumns = {@JoinColumn(name = "id_employee")})
    private List<Employee> employees;

    private int status;

    public Patient() {
    }

    public Patient(String firstName, String secondName,
                   String dateOfBirth, String healthsComplaints) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.healthsComplaints = healthsComplaints;
    }

   public void addEmployeeToPatient(Employee employee) {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        employees.add(employee);
    }

    @Override
    public String toString() {
        return firstName+ " "+secondName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
