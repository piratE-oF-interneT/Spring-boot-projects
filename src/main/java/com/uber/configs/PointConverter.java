package com.uber.configs;


import jakarta.persistence.AttributeConverter;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
//import org.hibernate.spatial.GeometryType;

public class PointConverter implements AttributeConverter<Point, Geometry> {

    @Override
    public Geometry convertToDatabaseColumn(Point point) {
        // Ensure the SRID is correct before storing the Point
        point.setSRID(4326);
        return point;
    }

    @Override
    public Point convertToEntityAttribute(Geometry geometry) {
        return (Point) geometry;
    }
}
