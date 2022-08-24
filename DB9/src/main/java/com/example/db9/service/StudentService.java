package com.example.db9.service;
import com.example.db9.exception.NoGradeException;
import com.example.db9.exception.SpecialtyNotFoundException;
import com.example.db9.exception.StudentNotFoundException;
import com.example.db9.model.Grade;
import com.example.db9.model.Specialty;
import com.example.db9.model.Student;
import com.example.db9.repository.GradeRepository;
import com.example.db9.repository.SpecialtyRepository;
import com.example.db9.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final SpecialtyRepository specialtyRepository;

    private final GradeRepository gradeRepository;

    public List<Grade> getAllGradesByStudentId(Integer id) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException("The student does not exist");
        }
        return student.get().getGrades();
    }

    public List<Student> getAllStudentsWithAnnualAverageGreaterThanEight() {
        return studentRepository.findAll().stream()
                .filter(s -> {
                    try {
                        return s.getAnnualAverageGrade() > 8;
                    } catch (NoGradeException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }

    public void addGradeByStudentId(Integer gradeId, Integer studentId) throws StudentNotFoundException, NoGradeException {
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Grade> grade = gradeRepository.findById(gradeId);

        if (student.isEmpty()) {
            throw new StudentNotFoundException("The student does not exist");
        }

        if(grade.isEmpty()) {
            throw new NoGradeException("The grade does not exist");
        }

        student.get().addGrade(grade.get());
        studentRepository.save(student.get());
    }

    public Student getStudentWithHighestAnnualAverage() throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findAll().stream()
                .max(Comparator.comparing(s -> {
                    try {
                        return s.getAnnualAverageGrade();
                    } catch (NoGradeException e) {
                        throw new RuntimeException(e);
                    }
                }));
        if (student.isEmpty()) {
            throw new StudentNotFoundException("The student does not exist");
        }

        return student.get();

    }

    public Student getStudentWithHighestAnnualAverageAtASpecialty(Integer specialtyId) throws SpecialtyNotFoundException, StudentNotFoundException {
        Optional<Specialty> specialty = specialtyRepository.findById(specialtyId);

        if (specialty.isEmpty()) {
            throw new SpecialtyNotFoundException("The specialty does not exist");
        }

        List<Student> studentsSpecialty = studentRepository.findAll().stream()
                .filter(student -> student.getSpecialty().getName().equals(specialty.get().getName()))
                .collect(Collectors.toList());

        Optional<Student> student = studentsSpecialty.stream()
                .max(Comparator.comparing(s -> {
                    try {
                        return s.getAnnualAverageGrade();
                    } catch (NoGradeException e) {
                        throw new RuntimeException(e);
                    }
                }));

        if (student.isEmpty()) {
            throw new StudentNotFoundException("The student does not exist");
        }

        return student.get();

    }


}