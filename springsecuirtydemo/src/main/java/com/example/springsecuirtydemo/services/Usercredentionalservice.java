package com.example.springsecuirtydemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springsecuirtydemo.model.Usercredential;
import com.example.springsecuirtydemo.repostory.userrepository;

@Service
public class Usercredentionalservice {
	
	
	@Autowired
	private userrepository userrepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Usercredential saveuser(Usercredential usercredential) {
		usercredential.setPassword(passwordEncoder.encode(usercredential.getPassword()));
		
		return userrepository.save(usercredential);
	}

	public List<Usercredential> getallusers() {
		
		return userrepository.findAll();
	}

	public String getToken(String username) {
		
		return JWTService.generateToken(username);
		
		
		
		
	}

	public boolean validate(String token) {
		
		if(JWTService.validatetoken(token)) {
			return true;
		}
		return false;
	}
	
	

}
