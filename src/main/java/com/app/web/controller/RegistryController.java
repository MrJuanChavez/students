package com.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistryController {
	
	@GetMapping("/login")
	public String startSession() {
		return "login";
	}
	
	@GetMapping("/")
	public String displayHomePage() {
		return "index";
	}
}
