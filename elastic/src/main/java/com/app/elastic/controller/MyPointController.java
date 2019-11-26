package com.app.elastic.controller;

import com.app.dto.FullPointDTO;
import com.app.dto.PointWithRadiusDTO;
import com.app.elastic.entity.FullPoint;
import com.app.elastic.service.PointService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/point")
public class MyPointController {

    private PointService pointService;

    public MyPointController(PointService pointService){
        this.pointService = pointService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> newPoint(@RequestBody FullPointDTO myFullPoint){
        pointService.savePoints(myFullPoint);
        return new ResponseEntity<>("Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<FullPoint>> getAll(){
        return new ResponseEntity<>(pointService.getPoints(), HttpStatus.OK);
    }

    @PostMapping("/byRadius")
    public ResponseEntity<List<FullPoint>> searchByRadius(@RequestBody PointWithRadiusDTO pointWithRadiusDTO){
        return new ResponseEntity<>(pointService.getByRadius(pointWithRadiusDTO), HttpStatus.OK);
    }


}
