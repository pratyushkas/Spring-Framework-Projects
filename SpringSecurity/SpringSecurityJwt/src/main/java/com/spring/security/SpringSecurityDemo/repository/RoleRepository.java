package com.spring.security.SpringSecurityDemo.repository;

import com.spring.security.SpringSecurityDemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(String roleAdmin);
}
