package com.uber.services.impl;


import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

import com.uber.services.DistanceService;

@Service
public class DistanceServiceImpl implements DistanceService{

	@Override
	public Double calculateDistance(Point source, Point destination) {
		// TODO third party APi call to calculate distance
		
		
		
		return null;
	}

}
