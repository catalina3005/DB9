package com.example.spital.service;


import com.example.spital.dto.PatientDTO;
import com.example.spital.exceptions.NoDoctorException;
import com.example.spital.model.Doctor;
import com.example.spital.model.Patient;
import com.example.spital.model.Speciality;
import com.example.spital.model.Visit;
import com.example.spital.repository.DoctorRepository;
import com.example.spital.repository.PatientRepository;
import com.example.spital.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {

    final VisitRepository visitRepository;
    final PatientRepository patientRepository;

    final DoctorRepository doctorRepository;

    public List<Visit> getVisitsByCnpAndSpeciality(String cnp, Speciality speciality){
        PatientDTO p = patientRepository.findByCnp(cnp);
        if(p.getDoctorSpeciality() == speciality) {
            p.setCnp(cnp);
            p.setDoctorSpeciality(speciality);
        }
        return visitRepository.findByCnpAndSpeciality(p.getCnp(),p.getDoctorSpeciality());
    }

    public Visit addVisit(Visit visit){
        return visitRepository.save(visit);
    }
}