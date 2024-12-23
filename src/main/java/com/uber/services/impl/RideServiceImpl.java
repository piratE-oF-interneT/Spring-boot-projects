package com.uber.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uber.dtos.DriverDto;
import com.uber.dtos.RideDto;
import com.uber.dtos.RideRequestDto;
import com.uber.entities.Driver;
import com.uber.entities.Ride;
import com.uber.services.RideService;
import com.uber.services.RiderService;

@Service
public class RideServiceImpl implements RideService{

	@Override
	public Optional<DriverDto> matchDriver(RideRequestDto rideRequestDto) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public RideDto getRideById(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDto createNewRide(RideRequestDto rideRequestDto, Driver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDto updateRideStatus(Long rideId, Ride ride) {
		// TODO Auto-generated method stub
		return null;
	}

}
