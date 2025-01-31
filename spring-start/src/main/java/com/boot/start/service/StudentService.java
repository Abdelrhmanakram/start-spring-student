package com.boot.start.service;

import com.boot.start.model.Student;
import jakarta.transaction.SystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    Student saveStudent(Student student) throws SystemException;

    Student updateStudent(Student student) throws SystemException;

    void deleteStudent(Integer studentId) throws SystemException;

    List<Student> getStudents();

    Student getStudentByName(String studentName) throws SystemException;

    List<Student> getStudentByStartChar(String prefix) throws SystemException;

    List<Student> getStudentByEndChar(String suffix) throws SystemException;

    List<Student> getStudentByContainChar(String prefix) throws SystemException;
}
