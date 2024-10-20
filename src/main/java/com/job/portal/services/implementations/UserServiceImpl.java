package com.job.portal.services.implementations;

import java.util.List;
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
        User test = this.repoUser.findByUsername(user.getUsername());
        if (test != null) {
            System.out.println("User is already there !!");
        } else {
            for (UserRole ur : roles) {
                this.repoRole.save(ur.getRole());
            }
            user.getUserRoles().addAll(roles);
            test = this.repoUser.save(user);
        }

        return test;
    }

    @Override
    public List<User> getUsers() {
        return this.repoUser.findAll();
    }

    @Override
    public boolean deleteUser(Long id) {
        User usr = this.repoUser.findById(id).get();
        if (usr == null) {
            this.repoUser.delete(usr);
            return true;
        }
        return false;
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
        return user.getFname() + "Updated Successfully";
    }
}
