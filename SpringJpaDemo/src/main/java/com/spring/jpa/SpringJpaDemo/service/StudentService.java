package com.spring.jpa.SpringJpaDemo.service;

import com.spring.jpa.SpringJpaDemo.model.Department;
import com.spring.jpa.SpringJpaDemo.model.Student;
import com.spring.jpa.SpringJpaDemo.repository.DepartmentRepository;
import com.spring.jpa.SpringJpaDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public void saveStudent(Student student, long deptId){
        Optional<Department> department = departmentRepository.findById(deptId);
        student.setDepartment(department.get());
        studentRepository.save(student);
    }
    public void saveStudent(Student student, String deptName){
        Department department = new Department(deptName);
        departmentRepository.save(department);
        student.setDepartment(department);
        studentRepository.save(student);
    }

}
