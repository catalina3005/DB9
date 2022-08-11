package com.example.practice1.service;
import com.example.practice1.dto.PatientDTO;
import com.example.practice1.mapper.PatientMapper;
import com.example.practice1.models.Doctor;
import com.example.practice1.models.Patient;
import com.example.practice1.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class patientService {

    final PatientRepository patientRepository;
    final PatientMapper patientMapper;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    public Patient getPatientById(Integer id){
        System.out.println(patientRepository.findById(id).get());
        return patientRepository.findById(id).get();
    }

    public List<PatientDTO> getAllPatientsDTO(){
        return patientRepository.findAll().stream()
                .map(patientMapper::toPatientDTO)
                .collect(Collectors.toList());
    }
    public PatientDTO getPatientDTOById(Integer id){
        return patientMapper.toPatientDTO(patientRepository.getById(id));
    }

    public List<Patient> getAllByDoctor(Doctor doctor){
        return patientRepository.getAllByDoctor(doctor);
    }

    public List<PatientDTO> getAllDTOByDoctor(Doctor doctor){
        return patientRepository.getAllByDoctor(doctor).stream()
                .map(patientMapper::toPatientDTO)
                .collect(Collectors.toList());
    }

    public Patient getByCnp(String cnp){
        return patientRepository.getByCnp(cnp);
    }

    public PatientDTO getByCnpDTO(String cnp){
        return patientMapper.toPatientDTO(patientRepository.getByCnp(cnp));
    }

    public void savePatient(Patient patient){
        patientRepository.save(patient);
    }

    public void deletePatient(Integer id){
        patientRepository.deleteById(id);
    }
}