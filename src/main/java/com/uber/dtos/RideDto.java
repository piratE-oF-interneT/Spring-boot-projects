package com.uber.dtos;

import java.time.LocalDateTime;

import org.locationtech.jts.geom.Point;

public class RideDto {
	
	
	private Long rideId;
	
	private DriverDto driver;
	
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	private String otp;
	

	private String rideStatus;
	

	private RiderDto rider;
	
	private Point dropLocation;
	
	private Point pickUpLocation;
	

	private String payment;
	
	private Double fair;

}
