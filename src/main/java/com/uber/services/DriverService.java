package com.uber.services;

import org.springframework.stereotype.Service;

import com.uber.dtos.RideDto;
import com.uber.dtos.RiderDto;

public interface DriverService {
	
	RideDto startRide(RideDto rideDto);
	
	RideDto cancelRide(RideDto rideDto);
	
	RideDto endRide(RideDto rideDto);
	
	RiderDto rateRider(RiderDto riderDto);
	
	

}
