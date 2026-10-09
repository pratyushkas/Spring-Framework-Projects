package com.spring.jpa.SpringJpaDemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Department(String deptName) {
        this.name = deptName;
    }

    @OneToMany(mappedBy = "department")
    private List<Student> students = new ArrayList<>();
}
