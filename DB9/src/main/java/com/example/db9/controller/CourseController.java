package com.example.db9.controller;
import com.example.db9.model.Course;
import com.example.db9.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getAllCoursesWithMoreThanThreeCreditPoints() {
        return courseService.getAllCoursesWithMoreThanThreeCreditPoints();
    }
}