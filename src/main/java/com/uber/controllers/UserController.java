package com.uber.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uber.dtos.SignUpDto;
import com.uber.dtos.UserDto;
import com.uber.services.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<UserDto> createUser(@RequestBody SignUpDto signUpDto) {
		//TODO: process POST request
		
	 UserDto userDto = authService.signUpUser(signUpDto);
	 
	 return new ResponseEntity<UserDto>(userDto,HttpStatus.CREATED);
	}
	

}
