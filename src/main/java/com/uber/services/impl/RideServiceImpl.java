package com.uber.services.impl;

import java.util.Optional;
import java.util.Random;

import com.uber.entities.Rider;
import com.uber.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.uber.dtos.DriverDto;
import com.uber.dtos.RideDto;
import com.uber.dtos.RideRequestDto;
import com.uber.entities.Driver;
import com.uber.entities.Ride;
import com.uber.entities.RideRequest;
import com.uber.enums.RideRequestStatus;
import com.uber.enums.RideStatus;
import com.uber.repositories.RideRepository;
import com.uber.services.RideRequestService;
import com.uber.services.RideService;
import com.uber.services.RiderService;

import jakarta.transaction.Transactional;

@Service
public class RideServiceImpl implements RideService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RideRepository rideRepository;
	
	@Autowired
	private RideRequestService rideRequestService;

	@Override
	public Optional<DriverDto> matchDriver(RideRequestDto rideRequestDto) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Ride getRideById(Long rideId) {
		// TODO Auto-generated method stub
		return rideRepository.findById(rideId).orElseThrow(() -> new ResourceNotFoundException("ride not found with id "+rideId));
	}

	@Override
	public Ride createNewRide(RideRequest rideRequest, Driver driver) {
		// TODO Auto-generated method stub
		
//		set status to confirmed
		rideRequest.setStatus(RideRequestStatus.CONFIRMED);

		
		Ride ride = modelMapper.map(rideRequest, Ride.class);
		ride.setRideId(null);
		ride.setDriver(driver);
		ride.setRideStatus(RideStatus.CONFIRMED);
		
		String otp = generateOtp();
		
		ride.setOtp(otp);
		
	
//		ride.setRideStatus(RideStatus.CONFIRMED);

		rideRequestService.updateRideRequest(rideRequest);
		Ride savedRide =  rideRepository.save(ride);
		

		
		
		
		
		return savedRide;
	}

	@Override
	public Ride updateRideStatus(Long rideId, Ride ride , RideStatus status) {
		// TODO Auto-generated method stub
		ride.setRideStatus(status);
		return rideRepository.save(ride);
	}

	@Override
	public Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest) {



		return rideRepository.findByRider(rider , pageRequest);
	}

	private String generateOtp() {
		
		Random random = new Random();
		int otpInt = random.nextInt(1000, 10000);
		
		return String.format("%04d", otpInt);
	}

}
