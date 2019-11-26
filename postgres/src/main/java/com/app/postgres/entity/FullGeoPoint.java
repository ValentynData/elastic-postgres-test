package com.app.postgres.entity;

//import org.postgis.Geometry;
//import com.vividsolutions.jts.geom.Point;
//import org.postgis.Point;
//import org.springframework.data.geo.Point;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "full_geopoint")
public class FullGeoPoint extends BaseEntity {


    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    private Geometry location;
//    private Point location;

    private String country;

    private String city;

    private String street;

    public FullGeoPoint() {
    }

    public FullGeoPoint(String id, Geometry location, String country, String city, String street) {
        super.setId(id);
        this.location = location;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Geometry getLocation() {
        return location;
    }

    public void setLocation(Geometry location) {
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
