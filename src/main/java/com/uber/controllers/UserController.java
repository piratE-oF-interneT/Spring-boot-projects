package com.uber.controllers;

import com.uber.dtos.*;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.uber.services.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<SignUpResponseDto> createUser(@RequestBody SignUpDto signUpDto) {
		//TODO: process POST request
		

	 
	 return new ResponseEntity<SignUpResponseDto>(authService.signUpUser(signUpDto),HttpStatus.CREATED);
	}

//	called by admin
	@Secured("ROLE_ADMIN")
	@PostMapping("/onboardDriver")

	public ResponseEntity<UserDto> onBoardNewDriver(@RequestParam Long userId , @RequestBody OnBoardDriverDto onboardDriverDto ){

		return  new ResponseEntity<UserDto>(authService.onBoardNewDriver(userId , onboardDriverDto.getVehicleId()) , HttpStatus.CREATED);
	}

	@PostMapping("/login")

	public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginRequestDto loginRequestDto){

		return new ResponseEntity<>(authService.loginUser(loginRequestDto.getEmail() , loginRequestDto.getPassword()),HttpStatus.FOUND);

	}
	

}
