package com.job.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.portal.model.User;

public interface UserRepo extends JpaRepository<User,Long> {
    public User findByUsername(String username);
}
