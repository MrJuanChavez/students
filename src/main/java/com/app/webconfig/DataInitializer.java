package com.app.webconfig;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.app.web.repository.UserRepository;
import com.app.web.users.model.Rol;

@Component
public class DataInitializer {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	public DataInitializer(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Bean
	CommandLineRunner initRolesAndAdmin() {
		return args -> {
			Rol adminRole = new Rol("ROLE_ADMIN");
			
			if (userRepository.findByEmail("admin@gmail.com") == null) {
				com.app.web.users.model.User adminUser = new com.app.web.users.model.User("Admin",
						"User",
						"admin@gmail.com",
						passwordEncoder.encode("admin123"),
						Arrays.asList(adminRole));
						
						userRepository.save(adminUser);
			}
		};
	}
}
