package com.app.postgres.service;

import com.app.dto.FullPointDTO;
import com.app.dto.PointWithRadiusDTO;
import com.app.postgres.entity.FullGeoPoint;
import com.app.postgres.repository.PostGisRepository;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geomgraph.Position;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GeodeticCurve;
import org.gavaghan.geodesy.GlobalCoordinates;
import org.geolatte.geom.G2D;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class PointServiceImpl implements PointService {

    private PostGisRepository pointRepository;

    @Autowired
    public PointServiceImpl(PostGisRepository pointRepository){
        this.pointRepository = pointRepository;
    }


    @Override
    public List<FullGeoPoint> getPoints() {
        return pointRepository.findAll();
    }

    @Override
    public void savePoints(FullPointDTO fullPointDTO) {
        double lat = fullPointDTO.getLat();
        double lon = fullPointDTO.getLon();

        FullGeoPoint fullGeoPoint = new FullGeoPoint(String.valueOf(Math.random()),
                wktToGeometry("POINT(" + lon / 100 + " " + lat / 100 + ")") ,
                fullPointDTO.getCountry(),
                fullPointDTO.getCity(),
                fullPointDTO.getStreet());

        pointRepository.save(fullGeoPoint);
    }

    @Override
    public List<FullGeoPoint> getByRadius(PointWithRadiusDTO pointWithRadiusDTO) {
        Geometry geom = wktToGeometry("POINT(" + pointWithRadiusDTO.getLon() / 100 + " " + pointWithRadiusDTO.getLat() / 100 + ")");

        float geoRadius = (float)pointWithRadiusDTO.getRadius();
        List<FullGeoPoint> points= pointRepository.findLimited(geom, geoRadius, PageRequest.of(0, 10));

        return points;

    }


    private Geometry wktToGeometry(String wktPoint) {
        WKTReader fromText = new WKTReader();
        Geometry geom = null;
        try {
            geom = fromText.read(wktPoint);
        } catch (ParseException e) {
            throw new RuntimeException("Not a WKT string:" + wktPoint);
        }
        return geom;
    }
}
