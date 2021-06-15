package com.project.hospital.service;


import com.project.hospital.dto.PatientDto;
import com.project.hospital.exception.ValidationException;

import java.util.List;

public interface PatientService {
    List<PatientDto> findAll();

    PatientDto savePatient(PatientDto PatientDto) throws ValidationException;

    void deletePatient(Long id_patient);

    PatientDto findBySecondName(String secondName);
}
