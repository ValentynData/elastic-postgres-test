package com.app.postgres.repository;

import com.app.postgres.entity.FullGeoPoint;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.Distance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface PostGisRepository extends JpaRepository <FullGeoPoint,String> {

//    List<FullGeoPoint> findAllLocations(Geometry point, int distance);

    @Query("SELECT c FROM FullGeoPoint c WHERE dwithin(c.location, :point, :dist)=true")
    List<FullGeoPoint> findLimited(@Param("point") Geometry point, @Param("dist") float dist, Pageable pageable);

//    @Query("select l from FullGeoPoint l where ST_DWithin(l.location, :point, :radius)=true")
//    List<FullGeoPoint> findLimited(@Param("point") Geometry point, @Param("radius") float radius, Pageable pageable);
}
