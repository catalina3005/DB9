package com.example.practice1.repository;
import com.example.practice1.models.Doctor;
import com.example.practice1.models.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface doctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findAll();
    Doctor getById(Integer id);
    List<Doctor> getAllBySpecialty(Specialty specialty);
}