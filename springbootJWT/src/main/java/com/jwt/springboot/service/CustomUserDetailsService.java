package com.jwt.springboot.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.springboot.model.CustomUserDetails;
import com.jwt.springboot.model.User;
import com.jwt.springboot.repo.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	System.out.println("user name from custom user details : "+ username);
	User user = userRepo.findByUsername(username);	
	
	if(username==null) {
		throw new UsernameNotFoundException("username is null");
	}
	
	if(user==null) {
		throw new UsernameNotFoundException("User not found");
	}else {
		return new CustomUserDetails(user);
	}
		
		
//		//we are not configuring with database so we will create fake service.
//		if(username.equals("bhaven")) {
////			User user1 = new User("bhaven", "bhaven123", new ArrayList<>());
//			User user1 = new User();
//			user1.setUsername("bhaven");
//			user1.setPassword("bhaven1");
//			return new CustomUserDetails(user1);
//		}else {
//			throw new UsernameNotFoundException("user not found");
//		}
		
		
	}

}
