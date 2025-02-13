package com.uber.entities;

import java.util.Set;

import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Point;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
//@TypeDef(name = "jts_geometry", typeClass = org.hibernate.spatial.JTSGeometryType.class)
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	private Double rating;
	
	@JsonProperty(value = "isAvailable")
	private Boolean isAvailable;
	
	@Column(columnDefinition = "Geometry(Point,4326)")
//	@Type(type = "org.hibernate.spatial.GeometryType")
	private Point currentLocation;
	
	@OneToMany(mappedBy = "driver")
	private Set<Ride> rides;

	@Column(unique = true)
	private String VehicleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Point getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Point currentLocation) {
		this.currentLocation = currentLocation;
	}

	public Set<Ride> getRides() {
		return rides;
	}

	public void setRides(Set<Ride> rides) {
		this.rides = rides;
	}

	public String getVehicleId() {
		return VehicleId;
	}

	public void setVehicleId(String vehicleId) {
		VehicleId = vehicleId;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", user=" + user + ", rating=" + rating + ", isAvailable=" + isAvailable
				+ ", currentLocation=" + currentLocation + ", rides=" + rides + ", VehicleId=" + VehicleId
				+ ", getId()=" + getId() + ", getUser()=" + getUser() + ", getRating()=" + getRating()
				+ ", getIsAvailable()=" + getIsAvailable() + ", getCurrentLocation()=" + getCurrentLocation()
				+ ", getRides()=" + getRides() + ", getVehicleId()=" + getVehicleId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}
