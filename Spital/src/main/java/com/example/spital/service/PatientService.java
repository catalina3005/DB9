package com.example.spital.service;

import com.example.spital.dto.PatientDTO;
import com.example.spital.mapper.PatientMapper;
import com.example.spital.model.Doctor;
import com.example.spital.model.Patient;
import com.example.spital.model.Speciality;
import com.example.spital.model.Visit;
import com.example.spital.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {
    final PatientRepository patientRepository;

    final PatientMapper patientMapper;

   /* public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }*/

    public List<PatientDTO> getAllPatients(){
        return patientRepository.findAll().stream()
                .map(patientMapper::toPatientDTO)
                .collect(Collectors.toList());
    }

   /* public PatientDTO findByCnp(String cnp){
        return patientRepository.findByCnp(cnp);
    }*/

    public Patient getByCnp(String cnp){
        return patientRepository.getByCnp(cnp);
    }

    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }

}