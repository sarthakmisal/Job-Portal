package com.job.portal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.job.portal.model.Role;
import com.job.portal.model.User;
import com.job.portal.model.UserRole;
import com.job.portal.services.UserService;

@SpringBootApplication
public class JobPortalWithDurgeshApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobPortalWithDurgeshApplication.class, args);
		System.out.println("Starting Code...");
	}

	// @Autowired
	// private UserService uService;
	// implements CommandLineRunner
	// @Override
	// public void run(String... args) throws Exception {
	// User tUser = new User();
	// tUser.setFname("Sarthak");
	// tUser.setLname("Misal");
	// tUser.setEmail("sarthak@hotmail.com");
	// tUser.setPhone("7498605559");
	// tUser.setProfile("Dev");
	// tUser.setUsername("sarthakmisal");
	// tUser.setEnabled(true);
	// tUser.setPassword("misal");

	// Role tRole = new Role("Software Dev");
	// Set<UserRole> set = new HashSet<>();
	// UserRole tUserRole = new UserRole();
	// tUserRole.setRole(tRole);
	// tUserRole.setUser(tUser);
	// set.add(tUserRole);

	// User uu = this.uService.createUser(tUser, set);
	// System.out.println("just created [" + uu.getUsername() + " ]");
	// }
}
