package com.project.hospital.model.dao;

import com.project.hospital.model.entity.Employee;
import com.project.hospital.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
public interface PatientDao  extends JpaRepository<Patient, Integer> {
//    public Patient createPatient(Patient patient);
//    public void updatePatient(Patient patient);
//    public void deletePatient(long id);
//    public List<Map<String, Object>> searchPatientByName(String name);
//    public Patient searchPatientById(long id);


}


