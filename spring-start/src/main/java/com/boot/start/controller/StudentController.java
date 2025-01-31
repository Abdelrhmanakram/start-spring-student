package com.boot.start.controller;

import com.boot.start.model.Student;
import com.boot.start.service.StudentService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    Student  saveStudent(@RequestBody Student student) throws SystemException {

       return studentService.saveStudent(student);
    }

    @PutMapping("/update")
    Student updateStudent(@RequestBody Student student) throws SystemException {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete")
    void deleteStudent(@RequestBody Integer student) throws SystemException {

        studentService.deleteStudent(student);
    }

    @GetMapping
    List<Student> getAllStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/name")
    Student getStudentByName(String studentName) throws SystemException {
        return studentService.getStudentByName(studentName);
    }

    @GetMapping("/start-char")
    List<Student> getStudentByStartChar(@RequestParam String perfix) throws SystemException {
        return studentService.getStudentByStartChar(perfix);
    }

    @GetMapping("/end-char")
    List<Student> getStudentByEndChar(@RequestParam String suffix) throws SystemException {
        return studentService.getStudentByEndChar(suffix);
    }

    @GetMapping("/contain-char")
    List<Student> getStudentByContainChar(@RequestParam String perfix) throws SystemException {
        return studentService.getStudentByContainChar(perfix);
    }

    

}
