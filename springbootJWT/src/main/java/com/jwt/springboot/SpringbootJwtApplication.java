package com.jwt.springboot;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.jwt.springboot.model.User;
import com.jwt.springboot.repo.UserRepository;

@SpringBootApplication
public class SpringbootJwtApplication implements CommandLineRunner {

	@Autowired
	private static UserRepository userRepo;

	public static void createUser() {
		User user = new User();

		user.setUsername("bhaven");
		user.setPassword("bhaven123");
		user.setEmail("user@gmail.com");
		user.setEnable(true);
		user.setEnable(true);
		user.setRole("Admin");

		userRepo.save(user);
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringbootJwtApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//createUser();
	}

}
