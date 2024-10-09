package com.example.springsecuirtydemo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.springsecuirtydemo.services.Userservice;

import jakarta.servlet.http.HttpServlet;

@Configuration
@EnableWebSecurity
public class SecuirtyConfig {
	
	@Autowired
	private Userservice userservice;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
		
		
		http.csrf(csrf->csrf.disable()).authorizeHttpRequests(request->request.requestMatchers("/authenticate/register","/authenticate/users/validate","/authenticate/validate/token").permitAll().anyRequest().authenticated()).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults()).headers(headers->headers.frameOptions(frame->frame.sameOrigin()));
		
		return http.build();
		
	}
	
	//passowrd authentucation by retieving username ans passeowed
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		
		//this will compare the bycrpt passowrd
		//as we give normal password so it will convert into bycrpt and compare by belwo line
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		daoAuthenticationProvider.setUserDetailsService(userservice);
		
		return daoAuthenticationProvider;
		
	}
	
	
	@Bean
	AuthenticationManager authenticationManager (AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

}
