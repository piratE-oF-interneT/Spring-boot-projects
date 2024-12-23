package com.uber.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import com.uber.enums.PaymentMethod;
import com.uber.enums.RideRequestStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class RideRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rideRequestId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rider_id")
	private Rider rider;
	
	@Enumerated(EnumType.STRING)
	private RideRequestStatus status;
	
	@Column(columnDefinition = "Geometry(Point,4326)")
	private Point dropLocation;
	
	@Column(columnDefinition = "Geometry(Point,4326)")
	private Point pickUpLocation;
	
	@Enumerated(EnumType.STRING)
	private PaymentMethod payment;
	
	private Double fair;
	
	@CreationTimestamp
	private LocalDateTime requestTime;

	public Rider getRider() {
		return rider;
	}

	public void setRider(Rider rider) {
		this.rider = rider;
	}

	public RideRequestStatus getStatus() {
		return status;
	}

	public void setStatus(RideRequestStatus status) {
		this.status = status;
	}

	public Point getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(Point dropLocation) {
		this.dropLocation = dropLocation;
	}

	public Point getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(Point pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public PaymentMethod getPayment() {
		return payment;
	}

	public void setPayment(PaymentMethod payment) {
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
		return "RideRequest [rideRequestId=" + rideRequestId + ", rider=" + rider + ", status=" + status
				+ ", dropLocation=" + dropLocation + ", pickUpLocation=" + pickUpLocation + ", payment=" + payment
				+ ", fair=" + fair + ", requestTime=" + requestTime + "]";
	}
	
	
	
	
	

}
