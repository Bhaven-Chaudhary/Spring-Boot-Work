package com.jpa.exp;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.exp.dao.UserRepository;
import com.jpa.exp.entity.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		
		UserRepository userRepo = context.getBean(UserRepository.class);
		User user = new User();
		user.setName("bhaven");
		user.setCity("Nagpur");
		user.setStatus("Full stack developer");
		
//		save single user
//		User result = userRepo.save(user);
//		System.out.println(result);
		
		User user2 = new User();
		user2.setName("ABC");
		user2.setCity("test2");
		user2.setStatus("Full stack developer");
		
		User user3 = new User();
		user3.setName("XYZ");
		user3.setCity("test3");
		user3.setStatus("Full stack developer");
		
//		save multiple object at time to database
//		List<User> users = List.of(user2, user3);
//		Iterable<User> resultAll = userRepo.saveAll(users);
//		resultAll.forEach(userob->{
//			System.out.println(userob);
//		});
//		
		
//		upadate user of id 8
//		Optional<User> optional = userRepo.findById(8);
//		User user4 = optional.get();
//		user4.setName("Ankit");
//		User save = userRepo.save(user4);
//		System.out.println(save);
		
//		get all user
		Iterable<User> resultAll = userRepo.findAll();
		resultAll.forEach(obj->{
			System.out.println(obj);
		});
		
//		delete
//		userRepo.deleteById(9);
		
		
		
		
		
	}

}
