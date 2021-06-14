package com.project.hospital.service.impl;


import ch.qos.logback.classic.Logger;
import com.project.hospital.dto.PatientDto;
import com.project.hospital.exception.PatientNotFoundException;
import com.project.hospital.model.dao.PatientDao;
import com.project.hospital.model.entity.Patient;
import com.project.hospital.service.PatientService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientDao patientDao;
//    private final Logger logger;

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
    @Override
    public PatientDto getPatientById(Long id){
      return null;
    }

//    @Override
//    public Patient save(Patient patient) {
//
//        patient = patientDao.save(patient);
//        if (patient.getId_patient() > -1)
//            return patient;
//        else{
//            logger.error("A problem occurred during saving patient" );
//            throw new PatientNotFoundException("A problem occurred during saving patient" );
//        }
//    }
//
//    @Override
//    public Patient findBySecondName(String secondName) {
//        Optional<Patient> patient = patientDao.findBySecondName(secondName);
//        if (patient.isPresent())
//            return patient.get();
//        else {
//            logger.error("--Patient does not exist with this Second Name " + secondName);
//            throw new PatientNotFoundException("Patient does not exist with this Second Name" + secondName);
//        }
//    }
//
//    @Override
//    public Patient findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public Boolean update(Long id) {
//        return null;
//    }



    }


