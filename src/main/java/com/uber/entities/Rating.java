package com.uber.entities;

import jakarta.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double driverRating;

    private Double riderRating;

    @OneToOne
    private Ride ride;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Rider rider;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(Double driverRating) {
        this.driverRating = driverRating;
    }

    public Double getRiderRating() {
        return riderRating;
    }

    public void setRiderRating(Double riderRating) {
        this.riderRating = riderRating;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Rating(Long id, Double driverRating, Double riderRating, Ride ride, Driver driver, Rider rider) {
        this.id = id;
        this.driverRating = driverRating;
        this.riderRating = riderRating;
        this.ride = ride;
        this.driver = driver;
        this.rider = rider;
    }

    public Rating(){

    }
}
