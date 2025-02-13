package com.uber.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uber.entities.Ride;
import com.uber.entities.Rider;

@Repository

public interface RideRepository extends JpaRepository<Ride, Long>{

    Page<Ride> findByRider(Rider rider, Pageable pageRequest);
}
