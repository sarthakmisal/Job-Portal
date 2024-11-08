package com.job.portal.controller;

// BCRYPT
import org.mindrot.jbcrypt.BCrypt;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.job.portal.model.Role;
import com.job.portal.model.User;
import com.job.portal.model.UserRole;
import com.job.portal.services.TokenService;
import com.job.portal.services.UserService;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
// @CrossOrigin("http://localhost:4200/")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService uService;
    @Autowired
    private TokenService tService;
    private static final String SECRET_KEY = "sarthakmisal"; // Use a strong secret key in production

    @PostMapping("generate_token")
    public Map<String, String> generateToken(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Map<String, String> response = new HashMap<>();
        if (username == null || password == null) {
            response.put("status", "Error");
            return response;
        }
        User user = this.uService.getByUserName(username);
        if (user == null||!user.getPassword().equals(password)){
            response.put("Error", "User not found");
            return response;
        }
        response.put("status", "ok");
        String token = BCrypt.hashpw(username + password, BCrypt.gensalt(12)); // 12 is the work factor
        response.put("token", token);
        response.put("user", username);

        // Map<String, String> response = new HashMap<>();
        // String username = credentials.get("username");
        // String password = credentials.get("password");

        // if (username == null || password == null) {
        // response.put("status", "Error");
        // return response;
        // }

        // String token = generateSecureToken(username, password);

        // response.put("status", "ok");
        // response.put("token", token);
        this.tService.insertToken(token);
        return response;
    }

    @GetMapping("get_token")
    public Map<String, String> getToken() {
        Map<String, String> res = new HashMap<>();
        res.put("token", this.tService.getToken());
        return res;
    }

    @PostMapping("get_user_details")
    public User getUsDetails(@RequestBody User usr) {
        User ur = new User();
        // ur.setUsername(usr.getUsername());
        // ur.setPassword(usr.getPassword());
        // ur.setPassword();
        return this.tService.getUser(usr.getUsername());
        // ur.setEmail("lwda");
        // return ur;
    }

    private String generateSecureToken(String username, String password) {
        String dataToHash = username + ":" + password + ":" + System.currentTimeMillis();
        return hashData(dataToHash);
    }

    private String hashData(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("update/{id}")
    public String putMethodName(@PathVariable("id") Long id, @RequestBody User user) {
        return this.uService.updateUser(id, user);
    }

    @GetMapping("name/{username}")
    public User getMethodName(@PathVariable("username") String username) {
        return this.uService.getByUserName(username);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (this.uService.deleteUser(id))
            return "Deleted Successfully";
        return "Unable to delete";
    }

    @GetMapping("getUsers")
    public List<User> getMethodName() {
        return this.uService.getUsers();
    }

    @PostMapping("create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User us = uService.getByUserName(user.getUsername());

            if (us == null) {
                Set<UserRole> set = new HashSet<>();
                Role rl = new Role("Normal");
                UserRole ur = new UserRole();
                ur.setRole(rl);
                ur.setUser(user);
                set.add(ur);

                User uk = this.uService.createUser(user, set);
                return new ResponseEntity<>(uk.getFname(), HttpStatus.CREATED);
            }

            // Return 400 if the username already exists
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Log and return 500 status for server errors
            e.printStackTrace();
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}