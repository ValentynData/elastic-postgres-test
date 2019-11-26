package com.app.validate.service;

import com.app.validate.dto.ValidateDistanceDTO;
import org.springframework.stereotype.Service;

import static java.lang.Math.*;

@Service
public class ValidateDistanceService {

    public boolean validateDistance(ValidateDistanceDTO validateDistanceDTO){
        double radius = validateDistanceDTO.getRadius();
        double origLat = validateDistanceDTO.getOrigLat();
        double origLon = validateDistanceDTO.getOrigLon();
        double destLat = validateDistanceDTO.getDestLat();
        double destLon = validateDistanceDTO.getDestLon();

        double distance =  3956 * 2 * asin(sqrt(pow(sin((origLat - destLat) * PI/180/2), 2)
                + cos(origLat * PI/180) * cos(destLat * PI/180) * pow(sin((origLon - destLon) * PI/180/2), 2)));

        return radius >= distance;
    }

}
