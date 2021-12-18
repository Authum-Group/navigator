package com.solvd.navigator.service.impl;

import com.solvd.navigator.domain.Point;
import com.solvd.navigator.domain.Street;
import com.solvd.navigator.domain.Transition;
import com.solvd.navigator.domain.exception.EntityIsNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;
import com.solvd.navigator.persistence.PointRepository;
import com.solvd.navigator.persistence.mybatisImpl.PointRepositoryMyBatisImpl;
import com.solvd.navigator.service.PointService;
import com.solvd.navigator.service.StreetService;
import com.solvd.navigator.service.TransitionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PointServiceImpl implements PointService {

    private static final PointRepository POINT_REPOSITORY = new PointRepositoryMyBatisImpl();
    private static final TransitionService TRANSITION_SERVICE = new TransitionServiceImpl();
    private static final StreetService STREET_SERVICE = new StreetServiceImpl();
    private static String exceptionStub = "Exception when try to %s Point - %s";

    @Override
    public void create(Point point, Long streetId) throws EntityIsNotValidException, InvalidParametersException, ResourceNotFoundException {
        if (point == null) {
            throw new InvalidParametersException("Exception when try to create Point - object is null");
        }
        if (!isValid(point)) {
            throw new EntityIsNotValidException("Exception when try to create Point - object is not valid");
        }
        point.setId(null);
        Street street = null;
        if (streetId != null) {
            street = STREET_SERVICE.findById(streetId);
        }
        point.setStreet(street);
        POINT_REPOSITORY.create(point);
    }

    @Override
    public List<Point> findAll() throws ResourceNotFoundException {
        List<Point> points = POINT_REPOSITORY.findAll();
        List<Transition> transitions = TRANSITION_SERVICE.findAll();
        for (Point point : points) {
            List<Transition> ourTransitions = transitions.stream().filter(transition -> {
                return transition.getFrom().getId().equals(point.getId());
            }).collect(Collectors.toList());

            Map<Point, Double> availablePoints = new HashMap<>();
            for (Transition transition : ourTransitions) {
                Double latitudeFrom = transition.getFrom().getLatitude();
                Double longitudeFrom = transition.getFrom().getLongitude();
                Double latitudeTo = transition.getTo().getLatitude();
                Double longitudeTo = transition.getTo().getLongitude();
                Double cost = latLongToKM(latitudeFrom, longitudeFrom, latitudeTo, longitudeTo);
                availablePoints.put(transition.getTo(), cost);
            }
            point.setAvailablePoints(availablePoints);
        }
        return points;
    }

    @Override
    public Point findById(Long id) throws InvalidParametersException, ResourceNotFoundException {
        if (id == null) {
            throw new InvalidParametersException("Exception when try to find Point by id - id is null");
        }
        Point point = POINT_REPOSITORY.findById(id);
        if (point == null) {
            throw new ResourceNotFoundException("Exception when try to find Point by id - there are no Point with id=" + id);
        }

        List<Transition> transitions = TRANSITION_SERVICE.findAll();

        List<Transition> ourTransitions = transitions.stream().filter(transition -> {
            return transition.getFrom().getId().equals(point.getId());
        }).collect(Collectors.toList());

        Map<Point, Double> availablePoints = new HashMap<>();
        for (Transition transition : ourTransitions) {
            Double latitudeFrom = transition.getFrom().getLatitude();
            Double longitudeFrom = transition.getFrom().getLongitude();
            Double latitudeTo = transition.getTo().getLatitude();
            Double longitudeTo = transition.getTo().getLongitude();
            Double cost = latLongToKM(latitudeFrom, longitudeFrom, latitudeTo, longitudeTo);
            availablePoints.put(transition.getTo(), cost);
        }
        point.setAvailablePoints(availablePoints);

        return point;
    }

    @Override
    public void update(Point point) throws InvalidParametersException, ResourceNotFoundException, EntityIsNotValidException {
        if (point == null) {
            throw new InvalidParametersException("Exception when try to update Point - object is null");
        }
        if (point.getId() == null) {
            throw new InvalidParametersException("Exception when try to update Point = id is null");
        }
        findById(point.getId());

        if (!isValid(point)) {
            throw new EntityIsNotValidException("Exception when try to update Point - object is not valid");
        }
        POINT_REPOSITORY.update(point);
    }

    @Override
    public void delete(Point point) throws InvalidParametersException, ResourceNotFoundException {
        if (point == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "object is null"));
        }
        if (point.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "id is null"));
        }
        findById(point.getId());
        POINT_REPOSITORY.delete(point);
    }

    private boolean isValid(Point point) {
        return point.getName() != null &&
                point.getLatitude() != null &&
                point.getLongitude() != null &&
                point.getStreet() != null &&
                point.getType() != null;
    }

    private Double latLongToKM(Double lat1, Double lon1, Double lat2, Double lon2) {
        Double R = 6378.137; // Radius of earth in KM
        double dLat = lat2 * Math.PI / 180 - lat1 * Math.PI / 180;
        double dLon = lon2 * Math.PI / 180 - lon1 * Math.PI / 180;
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1 * Math.PI / 180) * Math.cos(lat2 * Math.PI / 180) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
