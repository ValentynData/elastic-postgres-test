package com.app.validate.dto;

public class ValidateDistanceDTO {

    private double radius;

    private double origLat;

    private double origLon;

    private double destLat;

    private double destLon;

    public ValidateDistanceDTO() {
    }

    public ValidateDistanceDTO(int radius, double origLat, double origLon, double destLat, double destLon) {
        this.radius = radius;
        this.origLat = origLat;
        this.origLon = origLon;
        this.destLat = destLat;
        this.destLon = destLon;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getOrigLat() {
        return origLat;
    }

    public void setOrigLat(double origLat) {
        this.origLat = origLat;
    }

    public double getOrigLon() {
        return origLon;
    }

    public void setOrigLon(double origLon) {
        this.origLon = origLon;
    }

    public double getDestLat() {
        return destLat;
    }

    public void setDestLat(double destLat) {
        this.destLat = destLat;
    }

    public double getDestLon() {
        return destLon;
    }

    public void setDestLon(double destLon) {
        this.destLon = destLon;
    }
}
