package com.jwt.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.springboot.model.User;
import com.jwt.springboot.repo.UserRepository;

@RestController
public class Controller {
	
	@Autowired
	public UserRepository userRepo;

	@GetMapping("/welcome")
		public String home() {
			String text = "This is the welcome page only for authorised user";
			return text;
	}
	
	@GetMapping("/getusers")
	public List<User> getUser() {
		
		List<User> user = userRepo.findAll();
		
		return user;
}

}
