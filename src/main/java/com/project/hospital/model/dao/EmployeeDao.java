package com.project.hospital.model.dao;


import com.project.hospital.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {
    List<Employee> getAllByFirstName(String firstName);

}
