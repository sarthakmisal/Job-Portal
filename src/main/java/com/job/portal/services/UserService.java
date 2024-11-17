package com.job.portal.services;

import java.util.List;
import java.util.Set;

// import org.springframework.stereotype.Service;

import com.job.portal.model.User;
import com.job.portal.model.UserRole;

public interface UserService {
    User createUser(User user, Set<UserRole> roles);

    List<User> getUsers();

    boolean deleteUser(Long id);

    String updateUser(Long id, User user);

    User getByUserName(String username);
}
