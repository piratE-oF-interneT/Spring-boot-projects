package com.uber.services;

import com.uber.dtos.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface AuthService {
	
	public SignUpResponseDto signUpUser(SignUpDto signUpDto);
	
	public LoginResponseDto loginUser(String email , String password);
	
	public UserDto onBoardNewDriver(Long userId , String vehicleId);





}
