package com.example.springsecuirtydemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecuirtydemo.model.Usercredential;
import com.example.springsecuirtydemo.repostory.userrepository;

@Service
public class Userservice implements UserDetailsService {
	
	@Autowired
	private userrepository userrepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 Usercredential userDetails =  userrepository.findByUsername(username);
		 
		 return new UserPrinciple(userDetails);
	}
	
	
	

}
