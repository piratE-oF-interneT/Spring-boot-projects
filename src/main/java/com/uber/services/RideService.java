package com.uber.services;

import java.util.Optional;

import com.uber.dtos.DriverDto;
import com.uber.dtos.RideDto;
import com.uber.dtos.RideRequestDto;
import com.uber.entities.Driver;
import com.uber.entities.Ride;
import com.uber.entities.RideRequest;
import com.uber.entities.Rider;
import com.uber.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {
	
	public Optional<DriverDto> matchDriver(RideRequestDto rideRequestDto);
	
	public Ride getRideById(Long rideId);
	
	public Ride createNewRide(RideRequest rideRequest,Driver driver);
	
	public Ride updateRideStatus(Long rideId , Ride ride , RideStatus status);

	public Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

}
