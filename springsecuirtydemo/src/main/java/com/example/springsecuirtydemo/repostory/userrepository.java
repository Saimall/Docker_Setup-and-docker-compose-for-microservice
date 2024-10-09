package com.example.springsecuirtydemo.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecuirtydemo.model.Usercredential;

@Repository
public interface userrepository  extends JpaRepository<Usercredential, Integer>{

	 Usercredential findByUsername(String username);
	
}
