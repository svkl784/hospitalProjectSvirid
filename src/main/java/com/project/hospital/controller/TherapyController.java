package com.project.hospital.controller;

import com.project.hospital.dto.PatientDto;
import com.project.hospital.dto.TherapyDto;
import com.project.hospital.service.TherapyService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TherapyController {
    private final TherapyService therapyService;

    public TherapyController(TherapyService therapyService) {
        this.therapyService = therapyService;
    }

    @GetMapping ("/allTherapy")
    public String getAllTherapy(Model model) {
        List<TherapyDto> allTherapy = therapyService.getAllTherapy();
        model.addAttribute("allTherapy", allTherapy);
        return "all-therapy";
    }
}
