package com.job.portal.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.job.portal.model.Role;
import com.job.portal.model.User;
import com.job.portal.model.UserRole;
import com.job.portal.services.UserService;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService uService;

    @GetMapping("getUsers")
    public String getMethodName() {
        return "hey there users";
    }

    @PostMapping("create")
    public String createUser(@RequestBody User user) {
        Set<UserRole> set = new HashSet<>();
        User usr = new User();
        usr.setFname(user.getFname());
        usr.setEmail(user.getEmail());
        usr.setLname(user.getLname());
        usr.setPassword(user.getPassword());
        usr.setPhone(user.getPhone());
        usr.setUsername(user.getUsername());
        // usr.set(user.get());
        Role rl = new Role("Normal");
        UserRole ur = new UserRole();
        ur.setRole(rl);
        ur.setUser(usr);
        set.add(new UserRole());
        this.uService.createUser(user, set);
        return "Welcome " + user.getFname();
    }
}