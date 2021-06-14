package com.project.hospital.controller;

import com.project.hospital.dto.PatientDto;
import com.project.hospital.model.entity.Patient;
import com.project.hospital.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public String getAllPatient(Model model) {
        List<PatientDto> allPatients = patientService.getAllPatient();
        model.addAttribute("allPatients", allPatients);
        return "all-patients";
    }
    @GetMapping("/createNewPatient")
    public String createNewPatient (Model model){
        Patient newPatient = new Patient();
        model.addAttribute("newPatient",newPatient);
        return "show-new-patient";
    }

    @GetMapping ("/patients/{id}")
    public PatientDto getPatientById (@PathVariable Long id) {
        PatientDto patient = patientService.getPatientById(id);
        return patient;
    }

//     @PostMapping
//     public String add(@RequestParam String firstName, @RequestParam String secondName,
//                       RequestParam String dateOfBirth, @RequestParam String healthsComplaints,
//                       Map<String, Object> model) {
//         Patient patient = new Patient(firstName,secondName,dateOfBirth, healthsComplaints);
//
//         patientService.save(patient);
//
//         Iterable<PatientDto> messages = patientService.getAllPatient();
//
//         model.put("newPatient", messages);
//
//         return "main";

//    @GetMapping("/savePatient")
//    public String saveNewPatient(@ModelAttribute){
//        return "redirect:/";
//    }
}

