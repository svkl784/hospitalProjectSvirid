package com.project.hospital.service.impl;

import com.project.hospital.dto.EmployeeDto;
import com.project.hospital.model.dao.EmployeeDao;
import com.project.hospital.model.entity.Employee;
import org.springframework.stereotype.Service;
import com.project.hospital.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeDao.findAll();

        List<EmployeeDto> employeeDtos = new ArrayList<>();

        employees.forEach(employee -> {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setFirstName(employee.getFirstName());
            employeeDto.setSecondName(employee.getSecondName());
            employeeDto.setDepartment(employee.getDepartment());
            employeeDto.setPatients(employee.getPatients());
            employeeDtos.add(employeeDto);
        });
        return employeeDtos;
    }
}