package com.example.spital.repository;

import com.example.spital.model.Speciality;
import com.example.spital.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    List<Visit> findAll();

    List<Visit> findByCnpAndSpeciality(String cnp, Speciality doctorSpeciality);
}