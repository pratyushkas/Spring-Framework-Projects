package com.spring.jpa.SpringJpaDemo.repository;

import com.spring.jpa.SpringJpaDemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
