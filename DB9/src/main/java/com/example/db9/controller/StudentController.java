package com.example.db9.controller;
import com.example.db9.exception.NoGradeException;
import com.example.db9.exception.SpecialtyNotFoundException;
import com.example.db9.exception.StudentNotFoundException;
import com.example.db9.model.Grade;
import com.example.db9.model.Student;
import com.example.db9.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("grades/{id}")
    public List<Grade> getAllGradesByStudentId(@PathVariable Integer id) throws StudentNotFoundException {
        return studentService.getAllGradesByStudentId(id);
    }

    @GetMapping("average")
    public List<Student> getAllStudentsWithAnnualAverageGreaterThanEight() {
        return studentService.getAllStudentsWithAnnualAverageGreaterThanEight();

    }

    @PostMapping("grades/add/{gradeId}/{studentId}")
    public void addGradeByStudentId(@PathVariable Integer gradeId, @PathVariable Integer studentId) throws StudentNotFoundException, NoGradeException {
        studentService.addGradeByStudentId(gradeId, studentId);
    }

    @GetMapping("most/average")
    public Student getStudentWithMostAnnualAverage() throws StudentNotFoundException {
        return studentService.getStudentWithHighestAnnualAverage();
    }

    @GetMapping("most/average/specialty/{specialtyId}")
    public Student getStudentWithHighestAnnualAverageAtASpecialty(@PathVariable Integer specialtyId) throws StudentNotFoundException, SpecialtyNotFoundException {
        return studentService.getStudentWithHighestAnnualAverageAtASpecialty(specialtyId);
    }


}