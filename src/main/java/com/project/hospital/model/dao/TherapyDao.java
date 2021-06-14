package com.project.hospital.model.dao;


import com.project.hospital.model.entity.Employee;
import com.project.hospital.model.entity.Therapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TherapyDao  extends JpaRepository<Therapy, Integer> {


}
