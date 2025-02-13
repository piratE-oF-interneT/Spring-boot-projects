package com.uber.stratigies;

import java.util.List;

import com.uber.dtos.RideRequestDto;
import com.uber.entities.Driver;
import com.uber.entities.RideRequest;

public interface DriverMatchingStrategy {
	
	public List<Driver> findMatchingDriver(RideRequest rideRequest);

}
