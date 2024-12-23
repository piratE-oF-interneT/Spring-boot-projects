package com.uber.stratigies;

import org.springframework.beans.factory.annotation.Value;

import com.uber.dtos.RideRequestDto;
import com.uber.entities.RideRequest;

public interface CalculateFairStrategy {
	
	final Double PER_KM_MULTIPLIER = 10.00;
	
	public Double calculateFair(RideRequest rideRequest);

}
