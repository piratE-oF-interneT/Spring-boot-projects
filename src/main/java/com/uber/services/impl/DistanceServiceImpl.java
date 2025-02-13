package com.uber.services.impl;


import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.uber.services.DistanceService;

@Service
public class DistanceServiceImpl implements DistanceService{
	

	
	private final String BASE_URL = "https://router.project-osrm.org/route/";

	@Override
	public Double calculateDistance(Point source, Point destination) {
		// TODO third party API(OSRM) call to calculate distance
		
		Double sourceX = source.getX(); //source longitude
		Double sourceY = source.getY(); // source latitude
		Double destinationX = destination.getX(); // source longitude
		Double destinationY = destination.getY(); //source latitude;
		
		RestClient restClient = RestClient.
				builder()
				.baseUrl(BASE_URL)
				.build();
		
		OsrmResponseDto osrmResponseDto = restClient
				.get()
				.uri("/v1/driving/{sourceX},{sourceY};{destinationX},{destinationY}?overview=false",sourceX,sourceY,destinationX,destinationY)
				.retrieve()
				.body(OsrmResponseDto.class);
		
		
		
		return osrmResponseDto.getRoutes().get(0).getDistance()/1000.0;
	}
	
}
	
	class OsrmRouteDto{
		
		private Double distance;

		public Double getDistance() {
			return distance;
		}

		public void setDistance(Double distance) {
			this.distance = distance;
		}

		public OsrmRouteDto() {
			super();
		}
		
		
		
		
	}
	class OsrmResponseDto{
		
		private List<OsrmRouteDto> routes;

		public List<OsrmRouteDto> getRoutes() {
			return routes;
		}

		public void setRoutes(List<OsrmRouteDto> routes) {
			this.routes = routes;
		}

		@Override
		public String toString() {
			return "OsrmResponseDto [routes=" + routes + "]";
		}

		public OsrmResponseDto() {
			super();
		}
		
		
		
		
		
	}


