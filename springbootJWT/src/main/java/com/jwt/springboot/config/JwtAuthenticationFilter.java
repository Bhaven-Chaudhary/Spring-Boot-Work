package com.jwt.springboot.config;

import java.io.IOException;



import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jwt.springboot.helper.JwtUtil;
import com.jwt.springboot.service.CustomUserDetailsService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// getting header from the request
		String requestTokenHeader = request.getHeader("Authorization");
		String userName = null;
		String jwtToken = null;

//		checking if token is present and has correct format
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {

//			extracting token from the incoming string
			jwtToken = requestTokenHeader.substring(7);

			try {

				userName = jwtUtil.extractUsername(jwtToken);
				 
				System.out.println("userName from jwt auth is :" +userName);

			} catch (Exception e) {

				e.printStackTrace();
				System.out.println("Not able to extract username");
			}

			UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);

			// security
			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			} else {

				System.out.println("Token is not Valid");
			}

		}
		
		filterChain.doFilter(request, response);

	}

}
