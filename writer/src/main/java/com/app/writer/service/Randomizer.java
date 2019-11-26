package com.app.writer.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Randomizer {

    private Random random;

    private double minLat;

    private double maxLat;

    private double minLon;

    private double maxLon;

    public Randomizer(Random random){
        this.random = random;
        this.minLat = -90;
        this.maxLat = 90;
        this.minLon = -180;
        this.maxLon = 180;
    }

    public double getRandomLat(){
        return random.nextInt((int)((maxLat - minLat) + 1)) + minLat;
    }

    public double getRandomLon(){
        return random.nextInt((int)((maxLon - minLon) + 1)) + minLon;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public double getMinLat() {
        return minLat;
    }

    public void setMinLat(double minLat) {
        this.minLat = minLat;
    }

    public double getMaxLat() {
        return maxLat;
    }

    public void setMaxLat(double maxLat) {
        this.maxLat = maxLat;
    }

    public double getMinLon() {
        return minLon;
    }

    public void setMinLon(double minLon) {
        this.minLon = minLon;
    }

    public double getMaxLon() {
        return maxLon;
    }

    public void setMaxLon(double maxLon) {
        this.maxLon = maxLon;
    }

}
