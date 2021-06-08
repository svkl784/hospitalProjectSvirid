package com.project.hospital.service.impl;

import com.project.hospital.dto.EmployeeDto;
import com.project.hospital.dto.PatientDto;
import com.project.hospital.model.dao.PatientDao;
import com.project.hospital.model.entity.Employee;
import com.project.hospital.model.entity.Patient;
import com.project.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public List<PatientDto> getAllPatient() {
        List<Patient> patients = patientDao.findAll();

        List<PatientDto> patientDtos = new ArrayList<>();

        patients.forEach(patient -> {
            PatientDto patientDto = new PatientDto();
            patientDto.setId_patient(patient.getId_patient());
            patientDto.setFirstName(patient.getFirstName());
            patientDto.setSecondName(patient.getSecondName());
            patientDto.setDateOfBirth(patient.getDateOfBirth());
            patientDto.setHealthsComplaints(patient.getHealthsComplaints());
            patientDtos.add(patientDto);
        });
        return patientDtos;
    }
}

