package com.project.hospital.model.dao;

import com.project.hospital.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDao  extends JpaRepository<Patient, Long> {
    Patient findBySecondName(String secondName);

}


