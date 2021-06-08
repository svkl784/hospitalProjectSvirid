package com.project.hospital.service.impl;


import com.project.hospital.dto.EmployeeDto;
import com.project.hospital.dto.TherapyDto;
import com.project.hospital.model.dao.TherapyDao;
import com.project.hospital.model.entity.Employee;
import com.project.hospital.model.entity.Therapy;
import com.project.hospital.service.TherapyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TherapyServiceImpl implements TherapyService {
    private final TherapyDao therapyDao;

    public TherapyServiceImpl(TherapyDao therapyDao) {
        this.therapyDao = therapyDao;
    }

    @Override

    public List<TherapyDto> getAllTherapy() {
        List<Therapy> therapies = therapyDao.findAll();

        List<TherapyDto> therapyDtos = new ArrayList<>();

        therapies.forEach(therapy -> {
            TherapyDto th = new TherapyDto();
            th.setId_therapy(therapy.getId_therapy());
            th.setId_category_therapy(therapy.getId_category_therapy());
            th.setId_patient(therapy.getId_patient());
            th.setName_therapy(therapy.getName_therapy());
            th.setId_employee(therapy.getId_employee());
            therapyDtos.add(th);
        });
        return therapyDtos;
    }
}
