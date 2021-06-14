package com.project.hospital.service;


import com.project.hospital.dto.PatientDto;
import com.project.hospital.model.entity.Patient;

import java.util.List;

public interface PatientService {
    List<PatientDto> getAllPatient();
    public PatientDto getPatientById(Long id);
//
//    Patient save(Patient patient);
//
//    Patient findBySecondName(String secondName);
//
//    Patient findById(Long id);
//
//    Boolean update(Long id);


}
