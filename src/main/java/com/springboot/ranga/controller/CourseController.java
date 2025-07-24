package com.springboot.ranga.controller;

import com.springboot.ranga.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public List<Course> fetchAllCourse() {
        return Arrays.asList(new Course(1, "Learn Java", "in28minutes"),
                new Course(2, "Learn SpringBoot", "in28minutes"),
                new Course(3, "Learn GCP", "in28minutes"),
                new Course(4, "Learn Kubernetes", "in28minutes"),
                new Course(5, "Learn Docker", "in28minutes")
        );
    }
}
