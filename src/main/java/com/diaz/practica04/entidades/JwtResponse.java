package com.diaz.practica04.entidades;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String token;
	
	private Long id;
	
	private String username;
	
	private List<String> roles;

	public JwtResponse(String token, Long id, String username, List<String> roles) {
		super();
		this.token = token;
		this.id = id;
		this.username = username;
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
