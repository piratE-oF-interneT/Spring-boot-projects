package com.uber.stratigies.impl;

import com.uber.dtos.DriverDto;
import com.uber.dtos.RiderDto;
import com.uber.entities.Driver;
import com.uber.entities.Rating;
import com.uber.entities.Ride;
import com.uber.entities.Rider;
import com.uber.exceptions.ResourceNotFoundException;
import com.uber.repositories.DriverRepository;
import com.uber.repositories.RatingRepository;
import com.uber.repositories.RiderRepository;
import com.uber.services.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private RiderRepository riderRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public DriverDto rateDriver(Ride ride, Double driverRating) {


        Driver driver = ride.getDriver();
        Rating ratingobj = ratingRepository.findByRide(ride).orElseThrow(() -> new ResourceNotFoundException("cannot get rating of ride"));
        ratingobj.setDriverRating(driverRating);
        ratingRepository.save(ratingobj);

        List<Rating> ratings = ratingRepository.findByDriver(ride.getDriver());

        Double avgRating = ratings.stream().mapToDouble(rating -> rating.getDriverRating()).average().orElse(0.0);

        driver.setRating(avgRating);

        return modelMapper.map(driverRepository.save(driver) , DriverDto.class);


    }

    @Override
    public RiderDto rateRider(Ride ride, Double riderRating) {

        Rider rider = ride.getRider();

        Rating ratingobj = ratingRepository.findByRide(ride).orElseThrow(() -> new ResourceNotFoundException("cannot get rating of ride"));
        ratingobj.setRiderRating(riderRating);
        ratingRepository.save(ratingobj);

        List<Rating> ratings = ratingRepository.findByRider(ride.getRider());

        Double avgRating = ratings.stream().mapToDouble(rating -> rating.getRiderRating()).average().orElse(0.0);

        rider.setRating(avgRating);

        return modelMapper.map(riderRepository.save(rider) , RiderDto.class);

    }

    @Override
    public Rating createNewRating(Ride ride) {

        Rating rating = new Rating();
        rating.setRide(ride);
        rating.setDriver(ride.getDriver());
        rating.setRider(ride.getRider());

        return ratingRepository.save(rating);


    }
}
