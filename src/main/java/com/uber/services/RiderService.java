package com.uber.services;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;

import com.uber.entities.Driver;
import com.uber.entities.Ride;
import org.apache.catalina.util.RateLimiter;

import com.uber.dtos.DriverDto;
import com.uber.dtos.RideDto;
import com.uber.dtos.RideRequestDto;
import com.uber.entities.Rider;
import com.uber.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RiderService {
	
	public RideRequestDto requestRide(RideRequestDto rideRequestDto);
	
	public RideDto cancelRide(Long rideId);
	
	public Page<RideDto> getAllMyRides(PageRequest pageRequest);
	
	public DriverDto rateDriver(Long rideId , Double rating);
	
	public Rider createRider(User user);
	
	public Rider getRider();

	public Rider updateRating(Rider rider , Double rating);

}
