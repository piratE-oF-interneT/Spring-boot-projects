package com.uber.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uber.dtos.RideRequestDto;
import com.uber.services.RiderService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
public class RiderController {
	
	@Autowired
	private  RiderService riderService;
	
	@PostMapping("/request")
	public ResponseEntity<RideRequestDto> requestRide(@RequestBody RideRequestDto rideRequestDto) {
		//TODO: process POST request
		
		RideRequestDto rideRequestDto2 = riderService.requestRide(rideRequestDto);
		
		return new ResponseEntity<RideRequestDto>(rideRequestDto,HttpStatus.OK);
	}
	

}
