package com.project.hospital.model.dao;


import com.project.hospital.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// CRUD - create, read, update, delete
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
//    List <Employee> getAllByFirstName(String firstName);

}
