package com.spring.security.SpringSecurityDemo.controller;

import com.spring.security.SpringSecurityDemo.model.Role;
import com.spring.security.SpringSecurityDemo.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<String> addRole(@RequestBody Role role){
        roleService.addRole(role);
        return ResponseEntity.ok(role.getRole()+" Role added!");
    }
}
