package com.uber.repositories;


import java.util.List;
import java.util.Optional;

import com.uber.entities.User;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uber.entities.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{


//	@Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickUpLocation) AS distance " +
//            "FROM app_driver d " +
//            "WHERE d.is_available = true AND ST_DWithin(d.current_location, :pickUpLocation, 10000) " +
//            "ORDER BY distance " +
//            "LIMIT 10",
//    nativeQuery = true)
//	
//
//	List<Driver> findNearestTenDriver(String pickUpLocation);
	
	@Query(value = "SELECT d.*, ST_Distance(d.current_location, ST_GeomFromText(:pickUpLocation, 4326)) AS distance " +
            "FROM driver d " +
            "WHERE d.is_available = true AND ST_DWithin(d.current_location, ST_GeomFromText(:pickUpLocation, 4326), 10000) " +
            "ORDER BY distance " +
            "LIMIT 10", 
    nativeQuery = true)
	List<Driver> findNearestTenDriver(@Param("pickUpLocation") String pickUpLocation);
	
	
	@Query(value = "SELECT d.* FROM driver d " +
            "WHERE d.is_available = true " +
            "AND ST_DWithin(d.current_location, ST_GeomFromText(:pickUpLocation, 4326), 15000) " +
            "ORDER BY d.rating DESC " +
            "LIMIT 10",
    nativeQuery = true)

	
	List<Driver> findNearestTopRatedDriver(String pickUpLocation);


	Optional<Driver> findByUser(User user);
}













