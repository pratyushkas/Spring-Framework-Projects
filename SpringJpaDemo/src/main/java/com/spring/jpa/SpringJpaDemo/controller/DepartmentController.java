package com.spring.jpa.SpringJpaDemo.controller;

import com.spring.jpa.SpringJpaDemo.model.Department;
import com.spring.jpa.SpringJpaDemo.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/dept")
public class DepartmentController {

    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> CreateDepartment(@RequestBody Department department){
        departmentService.createDept(department);
        return ResponseEntity.ok("Department record saved");
    }
}
