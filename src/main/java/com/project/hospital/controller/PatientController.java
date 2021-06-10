package com.project.hospital.controller;

import com.project.hospital.dto.EmployeeDto;
import com.project.hospital.dto.PatientDto;
import com.project.hospital.model.entity.Patient;
import com.project.hospital.service.PatientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping("/allPatients")
    public List<PatientDto> getAllPatient() {
        return patientService.getAllPatient();
    }
}

