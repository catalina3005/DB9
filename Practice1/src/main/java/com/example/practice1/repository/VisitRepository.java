package com.example.practice1.repository;
import com.example.practice1.models.Specialty;
import com.example.practice1.models.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    List<Visit> findAll();
    List<Visit> findAllByPatient_Cnp(String cnp);
    List<Visit> findAllByDoctor_Specialty(Specialty specialty);
}