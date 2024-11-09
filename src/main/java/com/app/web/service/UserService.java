package com.app.web.service;

import com.app.web.dto.UserRegistryDTO;
import com.app.web.users.model.User;

public interface UserService {
	
	public User save(UserRegistryDTO registryDTO);
}
