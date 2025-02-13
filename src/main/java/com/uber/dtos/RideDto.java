package com.uber.dtos;

import java.time.LocalDateTime;

import com.uber.entities.Driver;
import com.uber.entities.Rider;
import org.locationtech.jts.geom.Point;

public class RideDto {
	
	
	private Long rideId;
	
	private DriverDto driver;
	
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	private String otp;
	

	private String rideStatus;
	

	private RiderDto rider;
	
	private PointDto dropLocation;
	
	private PointDto pickUpLocation;

	private String payment;
	
	private Double fair;

	public Long getRideId() {
		return rideId;
	}

	public void setRideId(Long rideId) {
		this.rideId = rideId;
	}

	public DriverDto getDriver() {
		return driver;
	}

	public void setDriver(DriverDto driver) {
		this.driver = driver;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getRideStatus() {
		return rideStatus;
	}

	public void setRideStatus(String rideStatus) {
		this.rideStatus = rideStatus;
	}

	public RiderDto getRider() {
		return rider;
	}

	public void setRider(RiderDto rider) {
		this.rider = rider;
	}

	public PointDto getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(PointDto dropLocation) {
		this.dropLocation = dropLocation;
	}

	public PointDto getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(PointDto pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Double getFair() {
		return fair;
	}

	public void setFair(Double fair) {
		this.fair = fair;
	}
}
