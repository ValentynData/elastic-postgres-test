package com.app.postgres.service;

import com.app.dto.FullPointDTO;
import com.app.dto.PointWithRadiusDTO;
import com.app.postgres.entity.FullGeoPoint;

import java.util.List;


public interface PointService {
    List<FullGeoPoint> getPoints();
    void savePoints(FullPointDTO fullPointDTO);
    List<FullGeoPoint> getByRadius(PointWithRadiusDTO pointWithRadiusDTO);
}
