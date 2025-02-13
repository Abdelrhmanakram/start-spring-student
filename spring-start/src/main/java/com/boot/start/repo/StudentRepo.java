package com.boot.start.repo;

import com.boot.start.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    Student findByName(String name);

    List<Student> findByNameStartingWith(String prefix);

    List<Student> findByNameContaining(String prefix);

    List<Student> findByNameEndingWith(String suffix);

//    List<Student> extractByAddress(String address);
}
