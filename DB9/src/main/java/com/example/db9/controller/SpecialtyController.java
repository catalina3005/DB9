package com.example.db9.controller;
import com.example.db9.exception.NoGradeException;
import com.example.db9.exception.SpecialtyNotFoundException;
import com.example.db9.model.Specialty;
import com.example.db9.model.Student;
import com.example.db9.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("specialty")
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    @GetMapping("students/{id}")
    public List<Student> getAllStudentsBySpecialty(@PathVariable Integer id) throws SpecialtyNotFoundException {
        return specialtyService.getAllStudentsBySpecialty(id);
    }

    @GetMapping
    public Specialty getSpecialtyWithMostStudents() throws SpecialtyNotFoundException {
        return specialtyService.getSpecialtyWithMostStudents();
    }

    @GetMapping("average/{id}")
    public Integer getAverageAtASpecialty(Integer id) throws NoGradeException, SpecialtyNotFoundException {
        return specialtyService.getAverageAtASpecialty(id);
    }
}