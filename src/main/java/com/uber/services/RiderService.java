package com.uber.services;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;

import org.apache.catalina.util.RateLimiter;

import com.uber.dtos.DriverDto;
import com.uber.dtos.RideDto;
import com.uber.dtos.RideRequestDto;
import com.uber.entities.Rider;
import com.uber.entities.User;

public interface RiderService {
	
	public RideRequestDto requestRide(RideRequestDto rideRequestDto);
	
	public RideDto cancelRide(RideDto rideDto);
	
	public List<RideDto> getAllMyRides(Long riderId);
	
	public DriverDto rateDriver(Long rideId , Double rating);
	
	public Rider createRider(User user);


}
