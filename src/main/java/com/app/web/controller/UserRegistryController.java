package com.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.web.dto.UserRegistryDTO;
import com.app.web.service.UserService;

@Controller
@RequestMapping("/registry")
public class UserRegistryController {

	private UserService userService;

	public UserRegistryController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegistryDTO returnNewUserRegistryDTO() {
		return new UserRegistryDTO();
	}
	
	@GetMapping
	public String displayRegistryForm() {
		return "registry";
	}
	
	@PostMapping
	public String registryUserAccount(@ModelAttribute("user")UserRegistryDTO registryDTO) {
		userService.save(registryDTO);
	return "redirect:/registry?succed";
	}
}
