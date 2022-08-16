package com.pmikeladze.siteScript;

import com.pmikeladze.siteScript.entity.Role;
import com.pmikeladze.siteScript.entity.User;
import com.pmikeladze.siteScript.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class SiteScriptApplication implements CommandLineRunner {
@Autowired
private UserRepo userRepo;
	public static void main(String[] args) {
		SpringApplication.run(SiteScriptApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(userRepo.findAll().stream().noneMatch(login->login.getUsername().equals("Admin"))){
		User user=new User();
		user.setActive(true);
		user.setPassword("Admin");
		user.setUsername("Admin");
		user.setRoles(Collections.singleton(Role.ADMIN));
		userRepo.save(user);}


	}
}
