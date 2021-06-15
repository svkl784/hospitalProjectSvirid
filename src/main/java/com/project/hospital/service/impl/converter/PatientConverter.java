package com.project.hospital.service.impl.converter;

import com.project.hospital.dto.PatientDto;
import com.project.hospital.model.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientConverter {
    public Patient fromPatientDtoToPatient(PatientDto patientDto){
        Patient patient = new Patient();
        patient.setId_patient(patientDto.getId_patient());
        patient.setFirstName(patientDto.getFirstName());
        patient.setSecondName(patientDto.getSecondName());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setHealthsComplaints(patientDto.getHealthsComplaints());
        return patient;
    }

    public PatientDto fromPatientToPatientDto(Patient patient){
        PatientDto patientDto = new PatientDto();
        patientDto.setId_patient(patient.getId_patient());
        patientDto.setFirstName(patient.getFirstName());
        patientDto.setSecondName(patient.getSecondName());
        patientDto.setDateOfBirth(patient.getDateOfBirth());
        patientDto.setHealthsComplaints(patient.getHealthsComplaints());
        return patientDto;
    }

}
