package com.uber.configs;


import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.Return;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uber.dtos.PointDto;
import com.uber.utils.GeometryUtil;

import java.awt.image.renderable.ContextualRenderedImageFactory;

import org.locationtech.jts.geom.Point;


@Configuration
public class ModelMapperConfig {
	
	
	@Bean
	public ModelMapper getModelMapper() {
		
		ModelMapper mapper = new ModelMapper();
		
		mapper.typeMap(PointDto.class,Point.class).setConverter(context ->{
			PointDto pointDto  = context.getSource();
			return GeometryUtil.createPoint(pointDto);
		});
		
		mapper.typeMap(Point.class, PointDto.class).setConverter(context -> {
			Point point = context.getSource();
			Double[] coordinates = {
					point.getX(),
					point.getY()
			};
			
			PointDto pointDto = new PointDto();
			pointDto.setCoordinates(coordinates);
			
			return pointDto;
		});
		
		return mapper;
	}

}
