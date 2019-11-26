package com.app.validate.controller;

import com.app.validate.dto.ValidateDistanceDTO;
import com.app.validate.service.ValidateDistanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/validate")
public class ValidateDistanceController {

    private ValidateDistanceService validateDistanceService;

    public ValidateDistanceController(ValidateDistanceService validateDistanceService){
        this.validateDistanceService = validateDistanceService;
    }

    @PostMapping(value = "/distance")
    public ResponseEntity<String> validateDistance(@RequestBody  ValidateDistanceDTO validateDistanceDTO){
        if(validateDistanceService.validateDistance(validateDistanceDTO)){
            return new ResponseEntity<>("Congrats, distance is valid", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sorry, distance is not valid", HttpStatus.EXPECTATION_FAILED);
        }
    }

}
