package com.lmig.gfc.invoicify.config;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.UserRepository;

@Configuration
public class SeedData {

	public SeedData(UserRepository userRepository) {
		User user = new User();
		user.setUsername("jon");
		user.setPassword("password");
		userRepository.save(user);
	}
}
