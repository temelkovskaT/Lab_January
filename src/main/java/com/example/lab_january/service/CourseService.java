package com.example.lab_january.service;

import com.example.lab_january.model.Course;
import com.example.lab_january.model.Student;

import java.util.List;

public interface CourseService {
    List<Student> listStudentsByCourse(Long courseId);
    Course addStudentInCourse(String username, Long courseId);
}
