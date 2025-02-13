package com.uber.services;

import com.uber.dtos.DriverDto;
import com.uber.dtos.RiderDto;
import com.uber.entities.Rating;
import com.uber.entities.Ride;

public interface RatingService {

    public DriverDto rateDriver(Ride ride , Double driverRating);
    public RiderDto rateRider(Ride ride , Double riderRating);

    public Rating createNewRating(Ride ride);
}
