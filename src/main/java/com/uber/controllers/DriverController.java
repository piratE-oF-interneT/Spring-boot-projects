package com.uber.controllers;

import com.uber.dtos.*;
import com.uber.entities.Ride;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.uber.entities.RideRequest;
import com.uber.services.DriverService;

@RestController
@RequestMapping("/driver")
@Secured("ROLE_DRIVER")
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@PostMapping("/accept")
	
	public ResponseEntity<RideDto> acceptRide(@RequestParam Long rideRequestId){
		
		return new ResponseEntity<>(driverService.acceptRide(rideRequestId),HttpStatus.OK);
		
	
		
	}

	@PostMapping

	public ResponseEntity<RideDto> startRide(@RequestParam Long rideId ,@RequestParam String otp){

		 return new ResponseEntity<RideDto>(driverService.startRide(rideId , otp),HttpStatus.OK);
	}

	@PostMapping("/end")

	public ResponseEntity<RideDto> endRIde(@RequestParam Long rideId){



		return new ResponseEntity<>(driverService.endRide(rideId), HttpStatus.OK);
	}

	@PostMapping("/cancel")

	public ResponseEntity<RideDto> cancelRide(@RequestParam Long rideId){

		return new ResponseEntity<>(driverService.cancelRide(rideId),HttpStatus.OK);
	}

	@PostMapping("/rate")

	public ResponseEntity<RiderDto> rateRider(@RequestParam Long rideId ,@RequestBody RateDto rateDto){

		return new ResponseEntity<>(driverService.rateRider(rideId , rateDto.getRating()) , HttpStatus.OK);
	}

//	@GetMapping("/rides")
//
//	public ResponseEntity<Page<RideDto>> getAllRides(@RequestParam(defaultValue = "0") Integer pageOffset,
//													 @RequestParam(defaultValue = "5") Integer pageSize){
//		PageRequest pageRequest = PageRequest.of(pageOffset , pageSize);
//
//		return new ResponseEntity<>(driverService.(pageRequest),HttpStatus.OK);
//
//	}

	@PostMapping("/updateLocation")

//	TODO remove driver id after security impl
	public ResponseEntity<DriverDto> updateLocation(@RequestParam Long driverId ,@RequestBody UpdateLocationDto updateLocationDto){

		return new ResponseEntity<>(driverService.updateLocation(driverId , updateLocationDto),HttpStatus.CREATED);
	}




}
