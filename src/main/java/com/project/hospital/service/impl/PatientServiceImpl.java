package com.project.hospital.service.impl;


import com.project.hospital.dto.PatientDto;
import com.project.hospital.exception.ValidationException;
import com.project.hospital.model.dao.PatientDao;
import com.project.hospital.model.entity.Patient;
import com.project.hospital.service.PatientService;
import com.project.hospital.service.impl.converter.PatientConverter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;
    private final PatientConverter patientConverter;


    public PatientServiceImpl(PatientDao patientDao, PatientConverter patientConverter) {
        this.patientDao = patientDao;
        this.patientConverter = patientConverter;
    }


    @Override
    public List<PatientDto> findAll() {
        return patientDao.findAll()
                .stream()
                .map(patientConverter::fromPatientToPatientDto)
                .collect(Collectors.toList());
    }

    @Override
    public void savePatient(PatientDto patientDto) throws ValidationException{
        validatePatientDto(patientDto);
        Patient savedPatient = patientDao.save(patientConverter
                .fromPatientDtoToPatient(patientDto));
        patientConverter.fromPatientToPatientDto(savedPatient);
    }

    private void validatePatientDto(PatientDto patientDto) throws ValidationException {
        if (isNull(patientDto)) {
            throw new ValidationException("Patient is null");
        }
        if (isNull(patientDto.getFirstName()) || patientDto.getSecondName().isEmpty()) {
            throw new ValidationException("First name or second name are empty");
        } if (isNull(patientDto.getDateOfBirth()) || patientDto.getHealthsComplaints().isEmpty()) {
            throw new ValidationException("Date of birth or health complaints are empty");
        }
    }

    @Override
    public void deletePatient(Long id_patient) {
        patientDao.deleteById(id_patient);
    }

    @Override
    public PatientDto findBySecondName(String secondName) {
        Patient patient = patientDao.findBySecondName(secondName);
        if(patient!=null){
            return patientConverter.fromPatientToPatientDto(patient);
        }
        return null;
    }
}
