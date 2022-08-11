package com.example.practice1.repository;
import com.example.practice1.models.Doctor;
import com.example.practice1.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAll();
    Patient getById(Integer id);
    List<Patient> getAllByDoctor(Doctor doctor);
    Patient getByCnp(String cnp);
}