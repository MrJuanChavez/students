package com.app.web.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.web.dto.UserRegistryDTO;
import com.app.web.users.model.User;

public interface UserService extends UserDetailsService {
	
	public User save(UserRegistryDTO registryDTO);
}
