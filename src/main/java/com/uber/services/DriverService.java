package com.uber.services;

import com.uber.dtos.DriverDto;
import com.uber.dtos.UpdateLocationDto;
import com.uber.entities.Driver;
import com.uber.entities.Ride;
import com.uber.entities.User;
import org.springframework.stereotype.Service;

import com.uber.dtos.RideDto;
import com.uber.dtos.RiderDto;

public interface DriverService {
	
	RideDto startRide(Long rideId , String otp);
	
	RideDto cancelRide(Long rideId);
	
	RideDto endRide(Long rideId);
	

	RideDto acceptRide(Long RideRequestId);

	RiderDto rateRider(Long rideId , Double rating);


	Boolean updateAvailability(Driver driver , Boolean availability);

	Driver updateRating(Driver driver , Double rating);


	Driver createNewDriver(User user, String vehicleId);

	DriverDto updateLocation(Long driverId , UpdateLocationDto updateLocationDto);
}
