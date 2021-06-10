package com.project.hospital.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_department")
    private Integer id_department;
    @Column (name = "name_department")
    private String name_department;

    @OneToMany (cascade = {CascadeType.REFRESH,CascadeType.PERSIST,
            CascadeType.MERGE,CascadeType.DETACH},
            mappedBy = "department")
    private List <Employee> employees;

    public Department() {
    }

    public Department(String name_department) {
        this.name_department = name_department;
    }

    public void addEmployeeToDepartment (Employee employee){
        if (employees==null) {
            employees = new ArrayList<>();
        }
        employees.add(employee);
        employee.setDepartment(this); //если хочу сделать uni-directional связь, убрать этот код
    }

    @Override
    public String toString() {
        return name_department;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getId_department() {
        return id_department;
    }

    public void setId_department(Integer id_department) {
        this.id_department = id_department;
    }

    public String getName_department() {
        return name_department;
    }

    public void setName_department(String name_department) {
        this.name_department = name_department;
    }
}
