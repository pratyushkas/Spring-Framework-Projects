package com.spring.jpa.SpringJpaDemo.service;

import com.spring.jpa.SpringJpaDemo.model.Department;
import com.spring.jpa.SpringJpaDemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public void createDept(Department department){
        departmentRepository.save(department);
    }
}
