package com.example.springsecuirtydemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecuirtydemo.model.Usercredential;
import com.example.springsecuirtydemo.services.Usercredentionalservice;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/authenticate")
public class homecontroller {

	@Autowired
	private Usercredentionalservice usercredentionalservice;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String greet(HttpServletRequest request) {
		return "Hello Greet" + request.getSession().getId();
	}

	@PostMapping("/register")
	public Usercredential saveuser(@RequestBody Usercredential usercredential) {
		return usercredentionalservice.saveuser(usercredential);
	}

	@GetMapping("/validate/token")
	public boolean validatetoken(@RequestParam String token) {
		return usercredentionalservice.validate(token);
	}

	@PostMapping("/users/validate")
	public String validateuser(@RequestBody Usercredential user) {
		System.out.println("User " + user);
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		if (authentication.isAuthenticated()) {
			return usercredentionalservice.getToken(user.getUsername());
		}
		return null;

	}

	@GetMapping("/users")
	public List<Usercredential> allusers() {
		return usercredentionalservice.getallusers();
	}

}
