package com.uber.stratigies.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uber.entities.RideRequest;
import com.uber.services.DistanceService;
import com.uber.stratigies.CalculateFairStrategy;

@Service
public class CalculateSurgeFairStrategy implements CalculateFairStrategy{

	private  final Double SURGE_FACTOR = 50.0;
	
	@Autowired
	private DistanceService distanceService;
	
	@Override
	public Double calculateFair(RideRequest rideRequest) {
		// TODO Auto-generated method stub
		
		
		return distanceService
				.calculateDistance(rideRequest.getPickUpLocation(), rideRequest.getDropLocation()) *PER_KM_MULTIPLIER 
				+SURGE_FACTOR;
	}

}
