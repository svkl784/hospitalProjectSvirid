package com.project.hospital.controller;

import com.project.hospital.dto.PatientDto;
import com.project.hospital.exception.ValidationException;
import com.project.hospital.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController почему не работает??????????
@Controller
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    public PatientDto savePatient(@RequestBody PatientDto patientDto) throws ValidationException{
        return patientService.savePatient(patientDto);
    }
    @GetMapping("/findAllPatients")
    public String findAllPatients (Model model){
     List <PatientDto> allPatients = patientService.findAll();
     model.addAttribute("allPatients", allPatients);
        return "all-patients";
    }
    @GetMapping ("/findBySecondName")
    public PatientDto findBySecondName(@RequestParam String secondName, Model model){
        return patientService.findBySecondName(secondName);
    }

    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity <Void> deletePatient(@PathVariable Long id_patient){
        patientService.deletePatient(id_patient);
        return ResponseEntity.ok().build();
    }





//    @GetMapping("/patients")
//    public String getAllPatient(Model model) {
//        List<PatientDto> allPatients = patientService.getAllPatient();
//        model.addAttribute("allPatients", allPatients);
//        return "all-patients";
//    }
//    @GetMapping("/createNewPatient")
//    public String createNewPatient (Model model){
//        Patient newPatient = new Patient();
//        model.addAttribute("newPatient",newPatient);
//        return "show-new-patient";
//    }

//    @GetMapping ("/patients/{id}")
//    public PatientDto getPatientById (@PathVariable Long id) {
//        PatientDto patient = patientService.getPatientById(id);
//        return patient;
//    }

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

