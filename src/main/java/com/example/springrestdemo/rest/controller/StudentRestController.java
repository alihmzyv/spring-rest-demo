package com.example.springrestdemo.rest.controller;


import com.example.springrestdemo.entity.Student;
import com.example.springrestdemo.exception.custom.StudentNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    //@PostConstruct - used on a method that needs to be executed
    // after dependency injection is done to perform any initialization.
    @PostConstruct
    public void loadStudents() {
        Student std1 = new Student("Ali", "Hamzayev");
        Student std2 = new Student("Hasan", "Hasanov");
        this.students = new ArrayList<>();
        this.students.add(std1);
        this.students.add(std2);
    }

    @GetMapping("/students")
    public List<Student> students() {
        return this.students;
    }

    @GetMapping("/students/{id}")
    public Student students(@PathVariable int id) {
        try {
            return this.students.get(id);
        }
        catch (IndexOutOfBoundsException exc) {
            throw new StudentNotFoundException(String.format("Student could not be found: id = %d", id));
        }
    }
}
