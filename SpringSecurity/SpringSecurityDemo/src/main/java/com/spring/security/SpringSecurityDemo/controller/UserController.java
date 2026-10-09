package com.spring.security.SpringSecurityDemo.controller;

import com.spring.security.SpringSecurityDemo.dto.UserRegisterRequestDto;
import com.spring.security.SpringSecurityDemo.dto.UserRegisterResponseDto;
import com.spring.security.SpringSecurityDemo.service.UserRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserRegisterService userRegisterService;

    public UserController(UserRegisterService userRegisterService){
        this.userRegisterService = userRegisterService;
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> greeting(){
        return ResponseEntity.ok("Welcome to User Registration API!!");
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(
            @RequestBody UserRegisterRequestDto userRegisterRequestDto
            ){
        UserRegisterResponseDto responseDto
                = userRegisterService.userRegistration(userRegisterRequestDto);
        return ResponseEntity.ok(responseDto);
    }
}
