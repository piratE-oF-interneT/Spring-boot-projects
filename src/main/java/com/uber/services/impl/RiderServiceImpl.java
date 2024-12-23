package com.uber.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uber.dtos.DriverDto;
import com.uber.dtos.RideDto;
import com.uber.dtos.RideRequestDto;
import com.uber.entities.RideRequest;
import com.uber.entities.Rider;
import com.uber.entities.User;
import com.uber.enums.RideRequestStatus;
import com.uber.repositories.RideRepository;
import com.uber.repositories.RideRequestRepository;
import com.uber.repositories.RiderRepository;
import com.uber.services.RiderService;
import com.uber.stratigies.CalculateFairStrategy;

@Service
public class RiderServiceImpl implements RiderService{

	
	@Autowired
	
	private ModelMapper modelMapper;
	
	@Autowired
	private RiderRepository riderRepository;
	
	@Autowired
	private RideRequestRepository rideRequestRepository;
	
	@Autowired
	private CalculateFairStrategy calculateFairStrategy;
	
	@Override
	public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
		// TODO Auto-generated method stub
		
		RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
		
		rideRequest.setStatus(RideRequestStatus.PENDING);
		
		Double fair = calculateFairStrategy.calculateFair(rideRequest);
		rideRequest.setFair(fair);
		
		RideRequestDto updatedRideRequestDto = modelMapper.map(rideRequestRepository.save(rideRequest), RideRequestDto.class);
		
		System.out.println(updatedRideRequestDto);
		
		return updatedRideRequestDto;
	}

	@Override
	public RideDto cancelRide(RideDto rideDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RideDto> getAllMyRides(Long riderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverDto rateDriver(Long rideId, Double rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rider createRider(User user) {
		// TODO do it with builder dp later
		
		Rider rider = new Rider();
		
		rider.setRating(0.0);
		rider.setUser(user);
		rider.setRidesRequested(null);
		
		return rider;
	}

}
