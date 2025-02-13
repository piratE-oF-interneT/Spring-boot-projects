package com.uber.dtos;

import java.time.LocalDateTime;

import com.uber.entities.Rider;



public class RideRequestDto {
	
	
	private Long rideRequestId;
	

	private Rider rider;
	

	private String status;
	

	private PointDto dropLocation;
	

	private PointDto pickUpLocation;
	

	private String payment;
	
	private Double fair;
	

	private LocalDateTime requestTime;


	public Long getRideRequestId() {
		return rideRequestId;
	}


	public void setRideRequestId(Long rideRequestId) {
		this.rideRequestId = rideRequestId;
	}


	public Rider getRider() {
		return rider;
	}


	public void setRider(Rider rider) {
		this.rider = rider;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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


	public LocalDateTime getRequestTime() {
		return requestTime;
	}


	public void setRequestTime(LocalDateTime requestTime) {
		this.requestTime = requestTime;
	}

	

	@Override
	public String toString() {
		return "RideRequestDto [rideRequestId=" + rideRequestId + ", rider=" + rider + ", status=" + status
				+ ", dropLocation=" + dropLocation + ", pickUpLocation=" + pickUpLocation + ", payment=" + payment
				+ ", fair=" + fair + ", requestTime=" + requestTime + "]";
	}
	
	
	

}
