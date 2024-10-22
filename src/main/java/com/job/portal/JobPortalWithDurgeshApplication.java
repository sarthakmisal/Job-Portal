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
}
