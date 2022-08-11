package com.example.spital.repository;

import com.example.spital.model.Doctor;
import com.example.spital.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findAll();

    Doctor getById(Integer integer);

    List<Doctor> getAllBySpeciality(Speciality speciality);
}