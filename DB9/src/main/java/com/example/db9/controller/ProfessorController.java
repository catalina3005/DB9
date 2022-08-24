package com.example.db9.controller;
import com.example.db9.exception.ProfessorNotFoundException;
import com.example.db9.model.Course;
import com.example.db9.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping("courses/{id}")
    public List<Course> getAllCoursesByProfessorId(@PathVariable Integer id) throws ProfessorNotFoundException {
        return professorService.getAllCoursesByProfessorId(id);
    }
}