package com.job.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.portal.model.Role;

public interface RoleRepo extends JpaRepository<Role,Long> {
    
}