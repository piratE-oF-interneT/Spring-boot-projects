package com.uber.services.impl;

import java.util.Optional;
import java.util.Set;

import com.uber.dtos.*;
import com.uber.entities.Driver;
import com.uber.exceptions.ResourceNotFoundException;
import com.uber.security.JwtService;
import com.uber.services.*;
import org.hibernate.HibernateException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.uber.entities.Rider;
import com.uber.entities.User;
import com.uber.enums.Role;
import com.uber.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RiderService riderService;

	@Autowired
	private WalletService walletService;

	@Autowired
	private DriverService driverService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public SignUpResponseDto signUpUser(SignUpDto signUpDto) {

		String[] tokens = new String[2];

		// TODO Auto-generated method stub
		
		User user = modelMapper.map(signUpDto, User.class);
		user.setRoles(Set.of(Role.RIDER));
		user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));


		User savedUser = null;
		
		Optional<User> oldUser  = userRepository.findByEmail(user.getEmail());
		
		if (oldUser.isPresent()) {
			throw new RuntimeException("user with email : "+user.getEmail()+" already exists");
		}

		savedUser = userRepository.save(user);
		tokens[0] = jwtService.generateToken(savedUser);
		tokens[1] = jwtService.generateRefreshToken(savedUser);

		System.out.println(tokens[0]);
		System.out.println(tokens[1]);
		
//		TODO now create user related entities
		
		Rider rider = riderService.createRider(savedUser);
		walletService.createNewWallet(savedUser);

		SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
		signUpResponseDto.setTokens(tokens);
		
		
		return signUpResponseDto;
	
	}

	@Override
	public LoginResponseDto loginUser(String email, String password) {

		String[] tokens = new String[2];
		LoginResponseDto loginResponseDto = new LoginResponseDto();

		try{
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email ,password));
			User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("email not found"));
			String username = user.getUsername();
			tokens[0] = jwtService.generateToken(user);
			tokens[1] = jwtService.generateRefreshToken(user);
			loginResponseDto.setMessage("login successful");

		}
		catch (BadCredentialsException bc){

			throw new ResourceNotFoundException("wrong credentials");
		}
		catch (AuthenticationException ae){
//			create new user

			User user = new User();
			user.setEmail(email);
			user.setPassword(passwordEncoder.encode(password));
			user.setRoles(Set.of(Role.RIDER));

			User savedUser =  userRepository.save(user);
			Rider rider = riderService.createRider(savedUser);
			walletService.createNewWallet(savedUser);

			tokens[0] = jwtService.generateToken(user);
			tokens[1] = jwtService.generateRefreshToken(user);
		}

		loginResponseDto.setTokens(tokens);

		return loginResponseDto;
	}

	@Override
	public UserDto onBoardNewDriver(Long userId , String vehicleId) {
		// TODO check wheteher function is being called by admin or not..

		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with this id."));

		if (user.getRoles().contains(Role.DRIVER)){
			throw new RuntimeException("this user is already a driver");
		}

		user.getRoles().add(Role.DRIVER);

		Driver newDriver = driverService.createNewDriver(user , vehicleId);



		return modelMapper.map((userRepository.save(user)) , UserDto.class);
	}

	
	

}
