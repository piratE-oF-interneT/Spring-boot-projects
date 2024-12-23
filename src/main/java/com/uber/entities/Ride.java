package com.uber.entities;

import java.time.LocalDateTime;

import com.uber.enums.RideStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Ride {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rideId;
	
//	unidirectional mapping
	@OneToOne
	@JoinColumn(name = "ride_request_id")
	private RideRequest rideRequest;
	
	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;
	
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	private String otp;
	
	@Enumerated(EnumType.STRING)
	private RideStatus rideStatus;
	
	
	
	

}
