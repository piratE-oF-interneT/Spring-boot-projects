package com.uber.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uber.dtos.RideDto;
import com.uber.entities.RideRequest;
import com.uber.exceptions.ResourceNotFoundException;
import com.uber.repositories.RideRepository;
import com.uber.repositories.RideRequestRepository;
import com.uber.services.RideRequestService;

@Service
public class RideRequestServiceImpl implements RideRequestService{
	
	@Autowired
	private RideRequestRepository rideRequestRepository;

	@Override
	public RideRequest findById(Long rideRequestId) {
		// TODO Auto-generated method stub
		return rideRequestRepository.findById(rideRequestId).orElseThrow(() -> new ResourceNotFoundException("ride request not found with id : "+rideRequestId));
	}

	@Override
	public void updateRideRequest(RideRequest rideRequest) {
		// TODO Auto-generated method stub
		
		rideRequestRepository.findById(rideRequest.getRideRequestId()).orElseThrow(()-> new ResourceNotFoundException("no ride request found with id "+rideRequest.getRideRequestId()));
		
		rideRequestRepository.save(rideRequest);
		
	}

}
