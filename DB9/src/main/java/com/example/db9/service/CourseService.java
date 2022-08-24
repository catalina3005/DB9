package com.example.db9.service;
import com.example.db9.model.Course;
import com.example.db9.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCoursesWithMoreThanThreeCreditPoints() {
        return courseRepository.findAll().stream()
                .filter(course -> course.getCreditPoints() > 3)
                .collect(Collectors.toList());
    }

}
