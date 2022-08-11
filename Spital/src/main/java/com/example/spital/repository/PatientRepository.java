package com.example.spital.repository;
import com.example.spital.dto.PatientDTO;
import com.example.spital.model.Doctor;
import com.example.spital.model.Patient;
import com.example.spital.model.Speciality;
import com.example.spital.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAll();

    Patient getById(Integer id);
    Patient getByCnp(String cnp);
    PatientDTO findByCnp(String cnp);
}