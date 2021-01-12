package com.diaz.practica04.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diaz.practica04.auth.service.JWTService;
import com.diaz.practica04.entidades.JwtResponse;
import com.diaz.practica04.entidades.Usuario;
import com.diaz.practica04.services.UserDetailsImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginRestController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTService jwtService;
	
	@PostMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody Usuario usuario) throws IOException {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtService.create(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(),
												 roles));
	}
}
