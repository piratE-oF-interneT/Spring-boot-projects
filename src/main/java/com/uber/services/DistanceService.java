package com.uber.services;


import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


public interface DistanceService {
	
	
	
	public Double calculateDistance(Point source , Point destination);

}
