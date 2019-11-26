package com.app.elastic.service;

import com.app.dto.FullPointDTO;
import com.app.dto.PointWithRadiusDTO;
import com.app.elastic.entity.FullPoint;
import com.app.elastic.repository.PointRepository;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@Service
public class PointServiceImpl implements PointService {

    private PointRepository pointRepository;
    private ElasticsearchTemplate esTemplate;

    @Autowired
    public PointServiceImpl(PointRepository pointRepository, ElasticsearchTemplate esTemplate){
        this.pointRepository = pointRepository;
        this.esTemplate = esTemplate;
    }


    @Override
    public Iterable<FullPoint> getPoints() {

        return pointRepository.findAll();

    }

    @Override
    public void savePoints(FullPointDTO fullPointDTO) {
        double lat = fullPointDTO.getLat();
        double lon = fullPointDTO.getLon();
        FullPoint fullPoint = new FullPoint(fullPointDTO.getId(), new GeoPoint( lat / 100,
                lon / 100), fullPointDTO.getCountry(),
                fullPointDTO.getCity(), fullPointDTO.getStreet());
        pointRepository.save(fullPoint);
    }

    @Override
    public List<FullPoint> getByRadius(PointWithRadiusDTO pointWithRadiusDTO) {

        double lat = ((double)pointWithRadiusDTO.getLat()) / 100;
        double lon = ((double)pointWithRadiusDTO.getLon()) / 100;


//        List<FullPoint> list = pointRepository.findAllByLocationIsNear(new Point(lat , lon ),
//                new Distance(pointWithRadiusDTO.getRadius()), PageRequest.of(0, 10));
//
//        return list;
        GeoPoint geoPoint = new GeoPoint( lat / 100,lon / 100);
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withFilter(QueryBuilders.geoDistanceQuery("location")
                        .point(pointWithRadiusDTO.getLat(), pointWithRadiusDTO.getLon() )
                        .distance(pointWithRadiusDTO.getRadius(), DistanceUnit.KILOMETERS))
                .build();

        return esTemplate.queryForList(searchQuery, FullPoint.class);


    }
}
