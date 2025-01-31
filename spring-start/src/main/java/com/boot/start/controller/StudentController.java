package com.boot.start.controller;

import com.boot.start.model.Student;
import com.boot.start.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student/save")
    Student  saveStudent(@RequestBody Student student) {
       return studentService.saveStudent(student);
    }


}
