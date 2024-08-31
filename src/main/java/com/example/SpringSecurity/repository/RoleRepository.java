package com.example.SpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringSecurity.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
