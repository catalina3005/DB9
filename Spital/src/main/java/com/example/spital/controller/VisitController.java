package com.example.spital.controller;

import com.example.spital.model.Speciality;
import com.example.spital.model.Visit;
import com.example.spital.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitController {
    @Autowired
    VisitService visitService;

    // display all visits of a patient by cnp and speciality

    @GetMapping("visits")
    public List<Visit> getAllVisitByCnpAndSpeciality(@RequestParam String cnp, @RequestParam Speciality speciality){
        return visitService.getVisitsByCnpAndSpeciality(cnp, speciality);
    }


    @PostMapping("visits/add")
    public Visit addVisit(@RequestBody Visit visit){
        return visitService.addVisit(visit);
    }

}