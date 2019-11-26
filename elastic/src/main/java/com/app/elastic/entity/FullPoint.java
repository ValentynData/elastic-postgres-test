package com.app.elastic.entity;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Document(indexName = "fullpoint", type = "mypoint")
public class FullPoint extends BaseEntity{

    private GeoPoint location;

    private String country;

    private String city;

    private String street;

    public FullPoint() {
    }

    public FullPoint(String id, GeoPoint location, String country, String city, String street) {

        super.setId(id);
        this.location = location;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
