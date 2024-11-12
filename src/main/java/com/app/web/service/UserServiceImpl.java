package com.app.web.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.app.web.dto.UserRegistryDTO;
import com.app.web.repository.UserRepository;
import com.app.web.users.model.Rol;
import com.app.web.users.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public User save(UserRegistryDTO registryDTO) {
		User user = new User(registryDTO.getName(), 
				registryDTO.getLastname(), registryDTO.getEmail(), 
				registryDTO.getPassword(), Arrays.asList(new Rol("ROLE_USER")));	
		return userRepository.save(user);
	}

}
