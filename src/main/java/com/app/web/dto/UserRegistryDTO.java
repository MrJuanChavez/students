package com.app.web.dto;

public class UserRegistryDTO {

	private Long id;
	private String name;
	private String lastname;
	private String email;
	private String password;
	private boolean isAdmin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRegistryDTO(Long id, String name, String lastname, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public UserRegistryDTO(String name, String lastname, String email, String password) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public UserRegistryDTO(String email) {
		super();
		this.email = email;
	}

	public UserRegistryDTO() {
		super();
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
