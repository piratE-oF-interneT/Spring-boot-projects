package com.uber.services;

import com.uber.dtos.RideDto;
import com.uber.entities.RideRequest;

public interface RideRequestService {
	
	RideRequest findById(Long rideRequestId);

	void updateRideRequest(RideRequest rideRequest);

}
