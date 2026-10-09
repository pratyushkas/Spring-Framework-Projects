package com.spring.jpa.SpringJpaDemo.controller;

import com.spring.jpa.SpringJpaDemo.model.Student;
import com.spring.jpa.SpringJpaDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentConroller {
    StudentService studentService;

    public StudentConroller(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/{deptId}")
    public ResponseEntity<String> createStudent(@RequestBody Student student, @PathVariable long deptId){
        studentService.saveStudent(student,deptId);
        return ResponseEntity.ok("Student record saved");
    }

    @PostMapping("/withdept")
    public ResponseEntity<String> createStudent(@RequestBody Student student,
                                                @RequestParam String deptName){
        studentService.saveStudent(student,deptName);
        return ResponseEntity.ok("Student record saved");
    }
}
