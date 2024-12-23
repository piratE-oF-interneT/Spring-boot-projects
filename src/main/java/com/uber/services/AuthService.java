package com.uber.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uber.dtos.DriverDto;
import com.uber.dtos.SignUpDto;
import com.uber.dtos.UserDto;


public interface AuthService {
	
	public UserDto signUpUser(SignUpDto signUpDto);
	
	public  String loginUser(String email , String password);
	
	public DriverDto onBoardNewDriver(Long userId);



}
