package com.uber.entities;

import java.time.LocalDateTime;

import com.uber.configs.PointConverter;
import com.uber.enums.PaymentMethod;
import com.uber.enums.RideStatus;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

@Entity
@Table(
		indexes = {
				@Index(name="idx_ride_driver" , columnList = "driver_id"),
				@Index(name = "idx_ride_rider" , columnList = "rider_id")
		}
)
public class Ride {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rideId;
	
//	unidirectional mapping
	@OneToOne
	@JoinColumn(name = "rider_id")
	private Rider rider;

	@Convert(converter = PointConverter.class)
	@Column(columnDefinition = "Geometry(Point,4326)")
	private Point dropLocation;

	@Convert(converter = PointConverter.class)
	@Column(columnDefinition = "Geometry(Point,4326)")
	private Point pickUpLocation;

	@Enumerated(EnumType.STRING)
	private PaymentMethod payment;

	private Double fair;
	
	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;
	
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	private String otp;
	
	@Enumerated(EnumType.STRING)
	private RideStatus rideStatus;


	public Ride(Long rideId, Rider rider, Point dropLocation, Point pickUpLocation, PaymentMethod payment, Double fair, Driver driver, LocalDateTime startTime, LocalDateTime endTime, String otp, RideStatus rideStatus) {
		this.rideId = rideId;
		this.rider = rider;
		this.dropLocation = dropLocation;
		this.pickUpLocation = pickUpLocation;
		this.payment = payment;
		this.fair = fair;
		this.driver = driver;
		this.startTime = startTime;
		this.endTime = endTime;
		this.otp = otp;
		this.rideStatus = rideStatus;
	}


	

	public Ride() {
		super();
	}


	public Long getRideId() {
		return rideId;
	}

	public void setRideId(Long rideId) {
		this.rideId = rideId;
	}



	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
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

	public RideStatus getRideStatus() {
		return rideStatus;
	}

	public void setRideStatus(RideStatus rideStatus) {
		this.rideStatus = rideStatus;
	}

	public Rider getRider() {
		return rider;
	}

	public void setRider(Rider rider) {
		this.rider = rider;
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
}
