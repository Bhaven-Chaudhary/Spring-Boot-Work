package com.jwt.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.springboot.helper.JwtUtil;
import com.jwt.springboot.model.CustomUserDetails;
import com.jwt.springboot.model.JwtRequest;
import com.jwt.springboot.service.CustomUserDetailsService;

@RestController
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		System.out.println("printing jwt request username password"+jwtRequest.getUsername()+ " : "+jwtRequest.getPassword());
		System.out.println("in the token handler");
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		String token = jwtUtil.generateToken(userDetails);
		System.out.println("Jwt " + token);
		
		return ResponseEntity.ok(token);
		
	}
}
