package com.example.lab_january.repository;

import com.example.lab_january.model.Student;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {


    private List<Student> students= new ArrayList<>();

    @PostConstruct
    public void init(){
        students.add(new Student("tea.temelko","tte","Teodora","T"));
        students.add(new Student("ane.temelko","tte","Ane","T"));
        students.add(new Student("tea.2","tte","Tea2","T"));
        students.add(new Student("ane.2","tte","Ane2","T"));
        students.add(new Student("tea.3","tte","Tea3","T"));
    }

    public List<Student> findAllStudents(){
        return students;
    }

    public List<Student> findAllByNameOrSurname(String text){
        return
                students.stream().filter(r->r.getName().contains(text)
                || r.getSurname().contains(text)).collect(Collectors.toList());
    }

}
