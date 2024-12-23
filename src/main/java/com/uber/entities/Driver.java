package com.uber.entities;

import java.awt.Point;
import java.util.Set;

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
@Table(name="app_driver")
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
	private Point currentLocation;
	
	@OneToMany(mappedBy = "driver")
	private Set<Ride> rides;

	@Column(unique = true)
	private String VehicleId;
}
