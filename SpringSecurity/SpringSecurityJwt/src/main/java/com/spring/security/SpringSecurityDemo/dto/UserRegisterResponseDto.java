package com.spring.security.SpringSecurityDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRegisterResponseDto {

    private String username;
    private String message;
}
