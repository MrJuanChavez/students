package com.app.web.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.web.dto.UserRegistryDTO;
import com.app.web.repository.UserRepository;
import com.app.web.users.model.Rol;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	
	
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}



	@Override
	public com.app.web.users.model.User save(UserRegistryDTO registryDTO) {
		Rol defaultRole = new Rol("ROLE_ISER");
		Rol adminRole = new Rol("ROLE_AMIN");
		
		boolean isAdmin = registryDTO.isAdmin();
		
		com.app.web.users.model.User user = new com.app.web.users.model.User(
				registryDTO.getName(), 
				registryDTO.getLastname(), 
				registryDTO.getEmail(), 
				passwordEncoder.encode(registryDTO.getPassword()), 
				isAdmin ? Arrays.asList(adminRole, defaultRole) : Arrays.asList(defaultRole));	
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.app.web.users.model.User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid user or pasword");
		}
		System.out.println("Loaded user: " + username + ", Password: " + user.getPassword());
		
		return new User(user.getEmail(), user.getPassword(),mapAuthoritiesRoles(user.getRol()));
	}
	
	private Collection<? extends GrantedAuthority> mapAuthoritiesRoles(Collection<Rol> roles){
		return roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
	}

}
