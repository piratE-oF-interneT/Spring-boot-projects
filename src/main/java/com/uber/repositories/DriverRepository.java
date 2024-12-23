package com.uber.repositories;


import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uber.entities.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{

	@Query(value = "SELECT d.* , ST_Distance(d.current_location,:pickUpLocation) AS distance"
			+ "FROM drivers AS d"
			+ "where availabe=true AND ST_DWithin(d.current_location,:pickUpLocation,10000)"
			+ "ORDER BY distance"
			+ "LIMIT id",nativeQuery=true
			)
	List<Driver> findAllByLocation(Point pickUpLocation);
	
}
