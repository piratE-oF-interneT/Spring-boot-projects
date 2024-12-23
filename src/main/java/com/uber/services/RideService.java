package com.uber.services;

import java.util.Optional;

import com.uber.dtos.DriverDto;
import com.uber.dtos.RideDto;
import com.uber.dtos.RideRequestDto;
import com.uber.entities.Driver;
import com.uber.entities.Ride;
import com.uber.entities.RideRequest;

public interface RideService {
	
	public Optional<DriverDto> matchDriver(RideRequestDto rideRequestDto);
	
	public RideDto getRideById(Long rideId);
	
	public RideDto createNewRide(RideRequestDto rideRequestDto,Driver driver);
	
	public RideDto updateRideStatus(Long rideId , Ride ride);

}
