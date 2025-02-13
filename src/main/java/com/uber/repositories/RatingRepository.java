package com.uber.repositories;

import com.uber.entities.Driver;
import com.uber.entities.Rating;
import com.uber.entities.Ride;
import com.uber.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating , Long> {

    List<Rating> findByRider(Rider rider);

    Optional<Rating> findByRide(Ride ride);

    List<Rating> findByDriver(Driver driver);
}
