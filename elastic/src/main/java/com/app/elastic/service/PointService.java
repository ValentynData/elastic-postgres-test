package com.app.elastic.service;

import com.app.dto.FullPointDTO;
import com.app.dto.PointWithRadiusDTO;
import com.app.elastic.entity.FullPoint;

import java.util.List;


public interface PointService {
    Iterable<FullPoint> getPoints();
    void savePoints( FullPointDTO myFullPoint);
    List<FullPoint> getByRadius(PointWithRadiusDTO pointWithRadiusDTO);
}
