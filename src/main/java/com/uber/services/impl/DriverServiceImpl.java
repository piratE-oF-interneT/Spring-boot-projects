package com.uber.services.impl;

import com.uber.dtos.DriverDto;
import com.uber.dtos.UpdateLocationDto;
import com.uber.entities.*;
import com.uber.enums.RideStatus;
import com.uber.repositories.RiderRepository;
import com.uber.services.*;
import jakarta.transaction.Transactional;
import org.hibernate.HibernateException;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



import com.uber.dtos.RideDto;
import com.uber.dtos.RiderDto;
import com.uber.enums.RideRequestStatus;
import com.uber.exceptions.ResourceNotFoundException;
import com.uber.repositories.DriverRepository;

import java.time.LocalDateTime;

@Service
public class DriverServiceImpl implements DriverService{
	
	@Autowired
	
	private RideRequestService rideRequestService;
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private RideService rideService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private RiderRepository riderRepository;

	@Autowired
	private RatingService ratingService;

	@Override
	@Transactional
	public RideDto startRide(Long rideId , String otp) {
		// TODO Auto-generated method stub

		Ride ride = rideService.getRideById(rideId);
		Driver driver = getCurrentDriver();

		if (!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
			throw new RuntimeException("ride status is not confirmed");
		}

		if (!ride.getDriver().equals(driver)){

			throw new RuntimeException("driver not matched with the driver associated with ride");

		}

		if (!otp.equals(ride.getOtp())){
			throw new RuntimeException("otp did not match....");
		}

//		update ride status to ongoing
//		Boolean status = updateAvailability(driver , false);

		ride.setStartTime(LocalDateTime.now());



		Ride updatedRide = rideService.updateRideStatus(rideId,ride , RideStatus.ONGOING);

		//		create payment object for this ride

		paymentService.createNewPayment(updatedRide);


// create rating object for ride

		ratingService.createNewRating(ride);






		return modelMapper.map(updatedRide , RideDto.class);
	}

	@Override
	public RideDto cancelRide(Long rideId) {
		// TODO : requested by driver

		Ride ride = rideService.getRideById(rideId);

		Driver driver = getCurrentDriver();

		if (!driver.equals(ride.getDriver())){
			throw new RuntimeException("this driver is not allowed to request cancel ride request");
		}
		if (!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
			throw  new RuntimeException("this ride is alredy started or not started with status : "+ride.getRideStatus());
		}

		Ride updatedRide = rideService.updateRideStatus(ride.getRideId() , ride,RideStatus.CANCELLED);
		updateAvailability(driver , true);
		driverRepository.save(driver);

		return modelMapper.map(updatedRide,RideDto.class);
	}



	@Override
	public RideDto endRide(Long rideId) {
		// TODO Auto-generated method stub

		Driver driver = getCurrentDriver();

		Ride ride = rideService.getRideById(rideId);


		if (!driver.equals(ride.getDriver())){
			throw new ResourceNotFoundException("this driver is not authorised to end ride");

		}
		if (!ride.getRideStatus().equals(RideStatus.ONGOING)){
			throw  new ResourceNotFoundException("this ride cannot be ended as its not ongoing");

		}

		updateAvailability(driver , true);
		ride.setEndTime(LocalDateTime.now());
		Ride savedRide = rideService.updateRideStatus(ride.getRideId() , ride , RideStatus.COMPLETED);


//		initiate Payment

		paymentService.processPayment(savedRide);



		return modelMapper.map(savedRide , RideDto.class);
	}

	@Override
	public RiderDto rateRider(Long  rideId , Double rating) {
		// TODO Auto-generated method stub

		Ride ride = rideService.getRideById(rideId);

		Rider rider = ride.getRider();
		Driver driver = getCurrentDriver();

		if (!driver.equals(ride.getDriver())){
			throw new ResourceNotFoundException("invalid driver");
		}
		if (!ride.getRideStatus().equals(RideStatus.COMPLETED)){
			throw new ResourceNotFoundException("ride not completed yet");

		}






		return ratingService.rateRider(ride , rating);
	}

	@Override

	public RideDto acceptRide(Long rideRequestId) {
		// TODO Auto-generated method stub
		
//		fetch ride request object from id
		
		RideRequest rideRequest = rideRequestService.findById(rideRequestId);
		
		if (!rideRequest.getStatus().equals(RideRequestStatus.PENDING)) {
//			if status is not pending then throw exception
			
			throw new ResourceNotFoundException("riderequest status is not pending , instead it is : "+rideRequest.getStatus().name());
			
		}
//		else  proceed further
		
		Driver currentDriver = getCurrentDriver();
		updateAvailability(currentDriver , false);
		driverRepository.save(currentDriver);
		RideDto rideDto = modelMapper.map(rideService.createNewRide(rideRequest,currentDriver), RideDto.class);
		
		
		
		
		
		return rideDto;
	}

	@Override
	public Boolean updateAvailability(Driver driver, Boolean availability) throws HibernateException {
		driver.setIsAvailable(true);

		Boolean check = false;

		try{
			driverRepository.save(driver);
			check = true;

		}
		catch (HibernateException he){

			throw new RuntimeException("driver status cannot be updated..");

		}
		return check;


	}

	@Override
	public Driver updateRating(Driver driver, Double rating) {
		driver.setRating(rating);

		return driverRepository.save(driver);
	}

	@Override
	public Driver createNewDriver(User user, String vehicleId) {

		Driver driver = new Driver();
		driver.setUser(user);
		driver.setRating(0.0);
		driver.setVehicleId(vehicleId);
		driver.setIsAvailable(true);

		return driverRepository.save(driver);
	}

	@Override
	public DriverDto updateLocation(Long driverId, UpdateLocationDto updateLocationDto) {
		Driver driver = driverRepository.findById(driverId).orElseThrow(()-> new ResourceNotFoundException("driver not found with this id"));

		Point location = modelMapper.map(updateLocationDto.getLocation() , Point.class);

		driver.setCurrentLocation(location);

		return  modelMapper.map(driver , DriverDto.class);
	}

	private Driver getCurrentDriver() {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return driverRepository.findByUser(user).orElseThrow(() ->new ResourceNotFoundException("driver not found"));
		
	}

}
