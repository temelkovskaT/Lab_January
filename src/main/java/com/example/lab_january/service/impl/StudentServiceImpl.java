package com.example.lab_january.service.impl;

import com.example.lab_january.model.Student;
import com.example.lab_january.repository.StudentRepository;
import com.example.lab_january.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listAll() {
        return studentRepository.findAllStudents();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text) {
        if(text==null || text.isEmpty()){
            return null;
        }
        return studentRepository.findAllByNameOrSurname(text);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        if(username==null || password==null || name==null || surname == null){
            throw new IllegalArgumentException();
        }
        Student s = new Student(username,password,name,surname);
        studentRepository.findAllStudents().add(s);
        return s;
    }
}
