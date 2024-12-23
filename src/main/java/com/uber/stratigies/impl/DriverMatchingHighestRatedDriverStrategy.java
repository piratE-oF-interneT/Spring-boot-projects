package com.uber.stratigies.impl;

import java.sql.Driver;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uber.dtos.RideRequestDto;
import com.uber.stratigies.DriverMatchingStrategy;

@Service
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy{

	@Override
	public List<Driver> findMatchingDriver(RideRequestDto rideRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
