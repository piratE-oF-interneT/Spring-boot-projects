package com.uber.services.impl;

import java.util.Optional;
import java.util.Set;

import org.hibernate.HibernateException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uber.dtos.DriverDto;
import com.uber.dtos.SignUpDto;
import com.uber.dtos.UserDto;
import com.uber.entities.Rider;
import com.uber.entities.User;
import com.uber.enums.Role;
import com.uber.repositories.UserRepository;
import com.uber.services.AuthService;
import com.uber.services.RideService;
import com.uber.services.RiderService;

@Service
public class AuthServiceImpl implements AuthService{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RiderService riderService;

	@Override
	public UserDto signUpUser(SignUpDto signUpDto) {
		// TODO Auto-generated method stub
		
		User user = modelMapper.map(signUpDto, User.class);
		user.setRoles(Set.of(Role.RIDER));
		
		User savedUser = null;
		
		Optional<User> oldUser  = userRepository.findByEmail(user.getEmail());
		
		if (oldUser.isPresent()) {
			throw new RuntimeException("user with email : "+user.getEmail()+" already exists");
		}
		savedUser = userRepository.save(user);
		
//		TODO now create user related entities
		
		Rider rider = riderService.createRider(savedUser);
		
		
		return modelMapper.map(savedUser, UserDto.class);
	
	}

	@Override
	public String loginUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverDto onBoardNewDriver(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
