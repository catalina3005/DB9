package com.example.spital.controller;
import com.example.spital.dto.PatientDTO;
import com.example.spital.model.Patient;
import com.example.spital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    //display all patients

    @GetMapping("patient/all")
    public List<PatientDTO> getAllPatient(){
        return patientService.getAllPatients();
    }


    //display a patient by cnp

    @GetMapping("patient")
    public Patient getPatientByCnp(@RequestParam String cnp){
        return patientService.getByCnp(cnp);
    }


    @PostMapping("patient/add")
    public Patient addPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }


}