package com.boot.start.controller;

import com.boot.start.dto.StudentDto;
import com.boot.start.model.Student;
import com.boot.start.repo.StudentRepo;
import com.boot.start.service.StudentService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("/save")
    Student  saveStudent(@RequestBody @Validated StudentDto studentDto) throws SystemException {
       return studentService.saveStudent(studentDto);
    }

    @PutMapping("/update")
    Student updateStudent(@RequestBody Student student) throws SystemException {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{studentId}")
    void deleteStudent(@PathVariable("studentId") Integer studentId) throws SystemException {
        studentService.deleteStudent(studentId);
    }

    @GetMapping
    List<Student> getAllStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/name")
    Student getStudentByName(@RequestParam("studentName") String studentName) throws SystemException {
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

//    @GetMapping("/getStudentByAddress")
//    List<Student> getStudentByAddress(@RequestParam String address) throws SystemException {
//        return studentService.getStudentByAddress(address);
//    }

}
