package com.spring.security.SpringSecurityDemo.repository;

import com.spring.security.SpringSecurityDemo.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

     @EntityGraph(attributePaths = "roleSet")
     Optional<User> findByUsername(String username);
}
