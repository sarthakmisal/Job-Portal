package com.job.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.model.Role;
@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    
}