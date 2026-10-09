package com.spring.jpa.SpringJpaDemo.repository;

import com.spring.jpa.SpringJpaDemo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
