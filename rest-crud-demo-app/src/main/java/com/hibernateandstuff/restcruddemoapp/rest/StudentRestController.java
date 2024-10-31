package com.hibernateandstuff.restcruddemoapp.rest;

import com.hibernateandstuff.restcruddemoapp.entity.Student;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.DoubleStream.builder;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // define @PostConstruct to load the student data... only once
    @PostConstruct
    public void loadData() {

        students = new ArrayList<>();

        students.add(new Student("berke", "genç"));
        students.add(new Student("elif", "genç"));
        students.add(new Student("talha", "akkaya"));
        students.add(new Student("madam", "coco"));
    }

    //define end-point for /students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    //define end-point for /students/{studentId} - return the student at index
    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {

        // check the studentId to list size
        if ( (students.size() < studentId) || (studentId < 0) ) {
            throw new StudentNotFoundException("student id is not found - " + studentId);
        }

        return students.get(studentId);
    }

}











