package com.example.db9.service;
import com.example.db9.exception.ProfessorNotFoundException;
import com.example.db9.model.Course;
import com.example.db9.model.Professor;
import com.example.db9.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<Course> getAllCoursesByProfessorId(Integer id) throws ProfessorNotFoundException {
        Optional<Professor> professor = professorRepository.findById(id);
        if (professor.isEmpty()) {
            throw new ProfessorNotFoundException("The professor does not exist");
        }
        return professor.get().getCourses();

    }

}