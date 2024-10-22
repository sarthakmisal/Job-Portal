package com.job.portal.services.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.model.User;
import com.job.portal.model.UserRole;
import com.job.portal.repo.RoleRepo;
import com.job.portal.repo.UserRepo;
import com.job.portal.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleRepo repoRole;
    @Autowired
    private UserRepo repoUser;

    @Override
    public User createUser(User user, Set<UserRole> roles) {
        User savedUser = null; // Declare savedUser outside the try block
        try {
            // First, save the user
            savedUser = this.repoUser.save(user);
            // Then, assign the saved user to each UserRole and save the roles
            for (UserRole ur : roles) {
                ur.setUser(savedUser); // Set the user to the saved user
                this.repoRole.save(ur.getRole()); // Save the role (if not already saved)
            }
            savedUser.setUserRoles(roles); // Set the roles for the saved user
            this.repoUser.save(savedUser); // Update the user with roles
        } catch (Exception e) {
            System.out.println("Error saving user and roles: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        }
        return savedUser;
    }

    @Override
    public List<User> getUsers() {
        try {
            return this.repoUser.findAll();
            // List<User> ul=new ArrayList<>();
            // Collection<User> ud=
            // for(User u:ud){
            // ul.add(u);
            // }
            // return ul;

        } catch (Exception e) {
            System.out.println("Cannot fetch");
            // System.out.println(e);
            // e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public User getByUserName(String username){
        return this.repoUser.findByUsername(username);
    }
    @Override
    public boolean deleteUser(Long id) {
        this.repoUser.deleteById(id);
        // Optional<User> usr = this.repoUser.findById(id);
        // if (usr.isPresent()) {
        //     User user=usr.get();
            return true;
        // }
        // return false;
    }

    @Override
    public String updateUser(Long id, User user) {
        User usr = this.repoUser.findById(id).get();
        usr.setEmail(user.getEmail());
        usr.setEnabled(user.isEnabled());
        usr.setFname(user.getFname());
        usr.setLname(user.getLname());
        usr.setPassword(user.getPassword());
        usr.setPhone(user.getPhone());
        usr.setProfile(user.getProfile());
        usr.setUserRoles(user.getUserRoles());
        usr.setUsername(user.getUsername());
        this.repoUser.save(usr);
        return user.getFname() + " Updated Successfully";
    }
}
