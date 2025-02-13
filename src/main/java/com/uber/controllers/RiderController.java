package com.uber.controllers;

import com.uber.dtos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.uber.services.RiderService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
@Secured("ROLE_RIDER")
public class RiderController {
	
	@Autowired
	private  RiderService riderService;
	
	@PostMapping("/request")
	public ResponseEntity<RideRequestDto> requestRide(@RequestBody RideRequestDto rideRequestDto) {
		//TODO: process POST request
		
		RideRequestDto rideRequestDto2 = riderService.requestRide(rideRequestDto);
		
		return new ResponseEntity<RideRequestDto>(rideRequestDto2,HttpStatus.OK);
	}

	@PostMapping("/rate")

	public ResponseEntity<DriverDto> rateDriver(@RequestBody RateDto rateDto){

		return new ResponseEntity<>(riderService.rateDriver(rateDto.getRideId() , rateDto.getRating()),HttpStatus.OK);

	}

	@PostMapping("/cancel")

	public ResponseEntity<RideDto> cancelRide(@RequestParam Long rideId){

		return  new ResponseEntity<>(riderService.cancelRide(rideId),HttpStatus.OK);

	}

//	@GetMapping("/profile")
//
//	public ResponseEntity<RiderDto> getProfile(){
//
////		return  new ResponseEntity<>(riderService.)
//	}

	@GetMapping("/rides")

	public ResponseEntity<Page<RideDto>> getAllRides(@RequestParam(defaultValue = "0") Integer pageOffset,
													 @RequestParam(defaultValue = "5") Integer pageSize){
		PageRequest pageRequest = PageRequest.of(pageOffset , pageSize);

		return new ResponseEntity<>(riderService.getAllMyRides(pageRequest),HttpStatus.OK);

	}
	

}
