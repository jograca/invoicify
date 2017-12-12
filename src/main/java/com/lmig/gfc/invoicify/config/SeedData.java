package com.lmig.gfc.invoicify.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.UserRepository;

@Configuration
public class SeedData {

	public SeedData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		User user = new User();
		String encodedPassword = passwordEncoder.encode("password");
		user.setUsername("jon");
		user.setPassword(encodedPassword);
		userRepository.save(user);
	}
}
