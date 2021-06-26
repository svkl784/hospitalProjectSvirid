package com.project.hospital.controller;

import com.project.hospital.dto.PatientDto;
import com.project.hospital.exception.ValidationException;
import com.project.hospital.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping("/findAllPatients")
    public String findAllPatients (Model model){
     List <PatientDto> allPatients = patientService.findAll();
     model.addAttribute("allPatients", allPatients);
        return "allPatients";
    }
    @GetMapping("/newPatient")
    public String newPatient(Model model){
        model.addAttribute("newPatient", new PatientDto());
        return "new-patient";
    }
    @PostMapping("/savePatient")
    public String savePatient(@RequestBody PatientDto patientDto)
            throws ValidationException{
        patientService.savePatient(patientDto);

        return "redirect:/findAllPatients";
    }

    @GetMapping ("/findBySecondName")
    public String findBySecondName(@RequestParam String secondName, Model model){
        model.addAttribute("secondName",patientService.findBySecondName(secondName));
    return "find-by-secondName";
    }

    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity <Void> deletePatient(@PathVariable Long id_patient){
        patientService.deletePatient(id_patient);
        return ResponseEntity.ok().build();
    }


}

