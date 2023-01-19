package com.example.lab_january.service.impl;


import com.example.lab_january.model.Course;
import com.example.lab_january.model.Student;
import com.example.lab_january.repository.CourseRepository;
import com.example.lab_january.repository.StudentRepository;
import com.example.lab_january.service.CourseService;
import com.example.lab_january.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        if(courseId ==null){
            return null;
        }
        return courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        if(username==null || courseId==null){
            return null;
        }
        Course c = courseRepository.findById(courseId);
        Student s = studentRepository.findAllByNameOrSurname(username).get(0);
        courseRepository.addStudentToCourse(s,c);
        return c;
    }
}
