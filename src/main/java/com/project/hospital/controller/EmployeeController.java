package com.project.hospital.controller;

import com.project.hospital.dto.EmployeeDto;
import com.project.hospital.service.EmployeeService;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/allEmployees")
    public List <EmployeeDto> getAllEmployee() {
        return employeeService.getAll();
    }
}

