package com.example.Student.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Student.Bean.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
}
