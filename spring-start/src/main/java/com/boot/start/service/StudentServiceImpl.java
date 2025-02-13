package com.boot.start.service;

import com.boot.start.dto.StudentDto;
import com.boot.start.model.Student;
import com.boot.start.repo.StudentRepo;
import jakarta.transaction.SystemException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Student saveStudent(StudentDto studentDto) throws SystemException {

        if (Objects.nonNull(studentDto.getId()) && studentDto.getId() > 0) {
            throw new SystemException("invalid.id");
        }
        Student student = modelMapper.map(studentDto, Student.class);

      return  studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Student student) throws SystemException {

        if (Objects.isNull(student.getId())) {
            throw new SystemException("id must be not null");
        }

        return  studentRepo.save(student);
    }

    @Override
    public void deleteStudent( Integer studentId) throws SystemException {
        if (Objects.isNull(studentId)) {
            throw new SystemException("id must be not null");
        }

        studentRepo.deleteById(studentId);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentByName(String studentName) throws SystemException {
        return studentRepo.findByName(studentName);
    }

    @Override
    public List<Student> getStudentByStartChar(String perfix) throws SystemException {
        return studentRepo.findByNameStartingWith(perfix);
    }

    @Override
    public List<Student> getStudentByEndChar(String suffix) throws SystemException {
        return studentRepo.findByNameEndingWith(suffix);
    }

    @Override
    public List<Student> getStudentByContainChar(String perfix) throws SystemException {
        return studentRepo.findByNameContaining(perfix);
    }

//    @Override
//    public List<Student> getStudentByAddress(String address) throws SystemException {
//        return studentRepo.extractByAddress(address);
//    }


}
