package com.job.portal.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.job.portal.model.Role;
import com.job.portal.model.User;
import com.job.portal.model.UserRole;
import com.job.portal.services.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService uService;
    
    @PutMapping("update/{id}")
    public String putMethodName(@PathVariable("id") Long id, @RequestBody User user) {
               
        return this.uService.updateUser(id, user);
    }
    @GetMapping("name/{username}")
    public User getMethodName(@PathVariable("username") String username) {
        return this.uService.getByUserName(username);
    }
    
    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id){
        if(this.uService.deleteUser(id))    return "Deleted Successfully";
        return "Unable to delete";
    }

    @GetMapping("getUsers")
    public List<User> getMethodName() {
        return this.uService.getUsers();
    }

    @PostMapping("create")
    public String createUser(@RequestBody User user) {
        // User usr = new User();
        // usr.setFname(user.getFname());
        // usr.setEmail(user.getEmail());
        // usr.setLname(user.getLname());
        // usr.setPassword(user.getPassword());
        // usr.setPhone(user.getPhone());
        // usr.setUsername(user.getUsername());
        // usr.set(user.get());
        Set<UserRole> set = new HashSet<>();
        Role rl = new Role("Normal");
        UserRole ur = new UserRole();
        ur.setRole(rl);
        ur.setUser(user);
        set.add(ur);
        User uk=this.uService.createUser(user, set);
       return ur.getRole().getRoleName();
    }
}