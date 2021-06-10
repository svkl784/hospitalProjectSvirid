package com.project.hospital.controller;

import com.project.hospital.dto.TherapyDto;
import com.project.hospital.service.TherapyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TherapyController {
    private final TherapyService therapyService;

    public TherapyController(TherapyService therapyService) {
        this.therapyService = therapyService;
    }

    @RequestMapping("/allTherapy")
    public List<TherapyDto> getAllTherapy() {
        return therapyService.getAllTherapy();
    }

}
