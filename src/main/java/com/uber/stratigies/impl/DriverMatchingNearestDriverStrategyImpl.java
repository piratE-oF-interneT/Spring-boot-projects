package com.uber.stratigies.impl;

import java.sql.Driver;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uber.dtos.RideRequestDto;
import com.uber.entities.RideRequest;
import com.uber.repositories.DriverRepository;
import com.uber.stratigies.DriverMatchingStrategy;

@Service
public class DriverMatchingNearestDriverStrategyImpl implements DriverMatchingStrategy{

	@Autowired
	private DriverRepository driverRepository;
	
	@Override
	public List<Driver> findMatchingDriver(RideRequest rideRequest) {
		// TODO Auto-generated method stub
		
		driverRepository.findAllByLocation(rideRequest.getPickUpLocation());
		
		return null;
	}

}
