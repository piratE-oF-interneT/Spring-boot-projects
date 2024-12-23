package com.uber.dtos;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.uber.entities.Rider;
import com.uber.enums.PaymentMethod;
import com.uber.enums.RideRequestStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class RideRequestDto {
	
	
	private Long rideRequestId;
	

	private RiderDto rider;
	

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


	public RiderDto getRider() {
		return rider;
	}


	public void setRider(RiderDto rider) {
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
	
	

}
