package com.example.db9.service;
import com.example.db9.exception.NoGradeException;
import com.example.db9.exception.SpecialtyNotFoundException;
import com.example.db9.model.Specialty;
import com.example.db9.model.Student;
import com.example.db9.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public List<Student> getAllStudentsBySpecialty(Integer id) throws SpecialtyNotFoundException {
        Optional<Specialty> specialty = specialtyRepository.findById(id);
        if (specialty.isEmpty()) {
            throw new SpecialtyNotFoundException("The specialty does not exist");
        }
        return specialty.get().getStudents();

    }

    public Specialty getSpecialtyWithMostStudents() throws SpecialtyNotFoundException {
        Optional<Specialty> specialty = specialtyRepository.findAll().stream()
                .max(Comparator.comparing(s -> s.getStudents().size()));
        if (specialty.isEmpty()) {
            throw new SpecialtyNotFoundException("The specialty does not exist");
        }
        return specialty.get();

    }

    public Integer getAverageAtASpecialty(Integer id) throws SpecialtyNotFoundException, NoGradeException {
        Optional<Specialty> specialty = specialtyRepository.findById(id);
        if (specialty.isEmpty()) {
            throw new SpecialtyNotFoundException("The specialty does not exist");
        }
        Integer averageGrade = 0;
        List<Student> studentsSpecialty = specialty.get().getStudents();
        for (Student student : studentsSpecialty) {
            averageGrade += student.getAnnualAverageGrade();
        }
        return averageGrade / studentsSpecialty.size();

    }


}
