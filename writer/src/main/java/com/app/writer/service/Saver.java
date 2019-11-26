package com.app.writer.service;

import com.app.elastic.entity.FullPoint;
import com.app.elastic.repository.PointRepository;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;

@Service
public class Saver {

    private PointRepository pointRepository;

    private Randomizer randomizer;

    private FullPoint fullPoint;

    public Saver(PointRepository pointRepository, Randomizer randomizer){
        this.pointRepository = pointRepository;
        this.randomizer = randomizer;
    }

    @Async
    public Future<String> save(){
        List<FullPoint> fullPoints = new CopyOnWriteArrayList<>();
        for(int i = 0; i < 9_800; i++){
            fullPoint = new FullPoint();
            fullPoint.setLocation(new GeoPoint(randomizer.getRandomLat(), randomizer.getRandomLon()));
            fullPoint.setStreet("street");
            fullPoint.setCountry("country");
            fullPoints.add(fullPoint);
        }
        pointRepository.saveAll(fullPoints);
        return CompletableFuture.completedFuture("Done");
    }

}
