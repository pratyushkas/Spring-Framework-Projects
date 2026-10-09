package com.spring.security.SpringSecurityDemo.service;

import com.spring.security.SpringSecurityDemo.model.CustomUserDetails;
import com.spring.security.SpringSecurityDemo.model.User;
import com.spring.security.SpringSecurityDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username)
               .orElseThrow(() ->
                       new UsernameNotFoundException("User Not found"));
       return new CustomUserDetails(user);
    }
}
