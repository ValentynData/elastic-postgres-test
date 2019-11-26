package com.app.elastic.repository;

import com.app.elastic.entity.FullPoint;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

import java.util.List;

public interface PointRepository extends ElasticsearchRepository<FullPoint, String> {

    List<FullPoint> findAllByLocationIsNear(Point location, Distance radius, Pageable pageable);

}
