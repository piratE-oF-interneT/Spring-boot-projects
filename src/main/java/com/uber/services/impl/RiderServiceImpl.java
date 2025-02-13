package com.uber.services.impl;

import java.util.List;

import com.uber.dtos.RiderDto;
import com.uber.entities.*;
import com.uber.enums.RideStatus;
import com.uber.services.DriverService;
import com.uber.services.RatingService;
import com.uber.services.RideService;
import org.hibernate.sql.ast.tree.update.UpdateStatement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.uber.dtos.DriverDto;
import com.uber.dtos.RideDto;
import com.uber.dtos.RideRequestDto;
import com.uber.enums.RideRequestStatus;
import com.uber.exceptions.ResourceNotFoundException;
import com.uber.repositories.RideRepository;
import com.uber.repositories.RideRequestRepository;
import com.uber.repositories.RiderRepository;
import com.uber.services.RiderService;
import com.uber.stratigies.CalculateFairStrategy;
import com.uber.stratigies.RideStrategyManager;

import jakarta.transaction.Transactional;

@Service
public class RiderServiceImpl implements RiderService{

	
	@Autowired
	
	private ModelMapper modelMapper;
	
	@Autowired
	private RiderRepository riderRepository;
	
	@Autowired
	private RideRequestRepository rideRequestRepository;
	
	@Autowired
	private RideStrategyManager rideStrategyManager;

	@Autowired
	private RideService rideService;

	@Autowired
	private DriverService driverService;

	@Autowired
	private RatingService ratingService;
	
	@Override
	@Transactional
	public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
		// TODO Auto-generated method stub
		
		System.out.println(rideRequestDto);
		
		RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
		
		System.out.println(rideRequest);
		System.out.println(rideRequest.getPickUpLocation());
		
		rideRequest.setStatus(RideRequestStatus.PENDING);
		
		Rider rider = getRider(); // get the rider from ride request
		rideRequest.setRider(rider); // now rider is set to ride request entity 
		
		
		Double fair = rideStrategyManager.getFairCalculated().calculateFair(rideRequest);
		System.out.println(fair);
		rideRequest.setFair(fair);
		
		

		
		
		RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);
		
		List<Driver> matchingDrivers = rideStrategyManager.getMathedDriver(getRider()).findMatchingDriver(rideRequest);
		System.out.println(matchingDrivers);
		
		System.out.println(savedRideRequest);
		
		RideRequestDto updatedRideRequestDto = modelMapper.map(savedRideRequest, RideRequestDto.class);
		System.out.println(updatedRideRequestDto);
		return updatedRideRequestDto;
	}

	@Override
	public RideDto cancelRide(Long rideId) {
		// TODO Auto-generated method stub

		Ride ride = rideService.getRideById(rideId);

		Rider rider = getRider();

		if (!ride.getRider().equals(rider)){
			throw new RuntimeException("rider not authorised to cancel ride");
		}
		if (!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
			throw new RuntimeException("ride cannot be cancelled as its status is not confirmed..");
		}

		driverService.updateAvailability(ride.getDriver() , true);

		Ride updatedRide =  rideService.updateRideStatus(rideId , ride , RideStatus.CANCELLED);



		return modelMapper.map(updatedRide , RideDto.class);
	}

	@Override
	public Page<RideDto> getAllMyRides(PageRequest pageRequest) {
		// TODO Auto-generated method stub

		Rider currentRIder = getRider();


		return rideService.getAllRidesOfRider(currentRIder , pageRequest).map(ride -> modelMapper.map(ride , RideDto.class));
	}

	@Override
	public DriverDto rateDriver(Long  rideId, Double rating) {

		// TODO Auto-generated method stub

		Ride ride = rideService.getRideById(rideId);

		Rider rider = getRider();
		Driver driver = ride.getDriver();

		if (!rider.equals(ride.getRider())){
			throw new ResourceNotFoundException("invalid rider");
		}
		if (!ride.getRideStatus().equals(RideStatus.COMPLETED)){
			throw new ResourceNotFoundException("ride not completed yet");

		}

		DriverDto updatedDriver = ratingService.rateDriver(ride , rating);




		return updatedDriver;
	}



	@Override
	public Rider createRider(User user) {
		// TODO do it with builder dp later
		
		Rider rider = new Rider();
		
		rider.setRating(0.0);
		rider.setUser(user);
		rider.setRidesRequested(null);
		
		return riderRepository.save(rider);
	}

	@Override
	public  Rider getRider() {
		// TODO include spring security

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return riderRepository.findByUser(user).orElseThrow(()->new ResourceNotFoundException("cannot fetch rider ...."));
	}

	@Override
	public Rider updateRating(Rider rider, Double rating) {

//		TODO : improve rating logic later

		rider.setRating(rating);

		return riderRepository.save(rider);
	}

}
