package com.uber.stratigies;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uber.entities.Rider;
import com.uber.stratigies.impl.CalculateDefaultFairStrategyImpl;
import com.uber.stratigies.impl.CalculateSurgeFairStrategy;
import com.uber.stratigies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.uber.stratigies.impl.DriverMatchingNearestDriverStrategyImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RideStrategyManager {
	
	@Autowired
	private DriverMatchingHighestRatedDriverStrategy driverMatchingHighestRatedDriverStrategy;
	@Autowired
	private DriverMatchingNearestDriverStrategyImpl driverMatchingNearestDriverStrategyImpl;
	
	@Autowired
	private CalculateDefaultFairStrategyImpl calculateDefaultFairStrategyImpl;
	@Autowired
	private CalculateSurgeFairStrategy calculateSurgeFairStrategy;
	
	
	public DriverMatchingStrategy getMathedDriver(Rider rider) {
		
		if (rider.getRating() >=4.0) {
			return driverMatchingHighestRatedDriverStrategy;
		}
		return driverMatchingNearestDriverStrategyImpl;
	}
	
	public CalculateFairStrategy getFairCalculated() {
		
		//TODO : surge time 6pm to 9 pm
		
		LocalTime currentTime = LocalTime.now();
		LocalTime surgeStartTime = LocalTime.of(18, 0);
		LocalTime surgeEndTime = LocalTime.of(21, 0);
		
		Boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);
		
		if (isSurgeTime) {
			return calculateSurgeFairStrategy;
		}
		return calculateDefaultFairStrategyImpl;
		
		
	}

}
