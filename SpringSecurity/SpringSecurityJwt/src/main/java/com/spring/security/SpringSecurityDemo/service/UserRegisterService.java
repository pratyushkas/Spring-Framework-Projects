package com.spring.security.SpringSecurityDemo.service;

import com.spring.security.SpringSecurityDemo.dto.UserRegisterRequestDto;
import com.spring.security.SpringSecurityDemo.dto.UserRegisterResponseDto;
import com.spring.security.SpringSecurityDemo.model.User;
import com.spring.security.SpringSecurityDemo.repository.RoleRepository;
import com.spring.security.SpringSecurityDemo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

   public UserRegisterService(UserRepository userRepository,
                              RoleRepository roleRepository, PasswordEncoder passwordEncoder){
       this.userRepository = userRepository;
       this.roleRepository = roleRepository;
       this.passwordEncoder = passwordEncoder;
   }

   public UserRegisterResponseDto userRegistration(
           UserRegisterRequestDto userRegisterRequestDto){
       User user = new User();
       user.setUsername(
               userRegisterRequestDto.getUsername()
       );
       String encodedPassword = passwordEncoder.encode(
               userRegisterRequestDto.getPassword()
       );

       user.setPassword(encodedPassword);
       user.setEnabled(true);

       user.getRoleSet().add(
               roleRepository.findByRole("ROLE_ADMIN").get()
       );
       userRepository.save(user);
       return new UserRegisterResponseDto(
               userRegisterRequestDto.getUsername(),
               "User created sucessfully"
       );
   }
}
