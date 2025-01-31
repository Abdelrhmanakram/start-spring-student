package com.boot.start.service;

import com.boot.start.model.Student;
import com.boot.start.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student saveStudent(Student student) {
      return  studentRepo.save(student);
    }
}
