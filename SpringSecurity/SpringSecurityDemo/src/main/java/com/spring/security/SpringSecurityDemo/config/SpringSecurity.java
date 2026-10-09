package com.spring.security.SpringSecurityDemo.config;

import com.spring.security.SpringSecurityDemo.model.CustomUserDetails;
import com.spring.security.SpringSecurityDemo.model.Role;
import com.spring.security.SpringSecurityDemo.repository.RoleRepository;
import com.spring.security.SpringSecurityDemo.service.CustomUserDetailsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
public class SpringSecurity {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(CustomUserDetailsService userDetailsService,
                                                               PasswordEncoder passwordEncoder){
        DaoAuthenticationProvider daoAuthenticationProvider =
                new DaoAuthenticationProvider(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   DaoAuthenticationProvider provider){
        return http.formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        auth ->
                                auth.requestMatchers("/api/user/register").permitAll()
                                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable())
                .authenticationProvider(provider).build();
    }

    @Bean
    public CommandLineRunner seedRoles(RoleRepository roleRepo){
        return args -> List.of("ROLE_ADMIN","ROLE_USER","ROLE_DEV").forEach(role ->
                roleRepo.findByRole(role).orElseGet(()->roleRepo.save(new Role(role)))
        );
    }
}
