package com.spring.security.SpringSecurityDemo.controller;

import com.spring.security.SpringSecurityDemo.dto.LoginRequestDto;
import com.spring.security.SpringSecurityDemo.dto.LoginResponseDto;
import com.spring.security.SpringSecurityDemo.service.JwtAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JwtAuthController {

    private JwtAuthService jwtAuthService;

    public JwtAuthController(JwtAuthService jwtAuthService){
        this.jwtAuthService = jwtAuthService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        String token = jwtAuthService.loginUser(loginRequestDto);
        return new ResponseEntity<>(new LoginResponseDto(token), HttpStatus.OK);
    }
}
