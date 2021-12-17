package com.solvd.navigator.service.impl;

import com.solvd.navigator.domain.Point;
import com.solvd.navigator.domain.Transition;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;
import com.solvd.navigator.domain.exception.ValidationException;
import com.solvd.navigator.persistence.PointRepository;
import com.solvd.navigator.persistence.mybatisImpl.PointRepositoryMyBatisImpl;
import com.solvd.navigator.service.PointService;
import com.solvd.navigator.service.TransitionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// TODO AvailablePoints
public class PointServiceImpl implements PointService {

    private static final PointRepository POINT_REPOSITORY = new PointRepositoryMyBatisImpl();
    private static final TransitionService TRANSITION_SERVICE = new TransitionServiceImpl();
    private static String exeptionStub = "Exception when try to %s Point - %s";

    @Override
    public void create(Point point) throws ValidationException, InvalidParametersException {
        if (point == null) {
            throw new InvalidParametersException("Exception when try to create Point - object is null");
        }
        if (!isValid(point)) {
            throw new ValidationException("Exception when try to create Point - object is not valid");
        }
        point.setId(null);
        POINT_REPOSITORY.create(point);
    }

    @Override
    public List<Point> findAll() throws ResourceNotFoundException {
        List<Point> points = POINT_REPOSITORY.findAll();
//        if (points.size() <= 0) {
//            throw new ResourceNotFoundException("Exception when try to get all Points - there are no Points in database");
//        }

        //TODO Simplify
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
                Double AC = Math.abs(longitudeTo - longitudeFrom);
                Double BC = Math.abs(latitudeTo - latitudeFrom);
                Double cost = Math.sqrt(Math.pow(AC, 2) + Math.pow(BC, 2));
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
            Double AC = Math.abs(longitudeTo - longitudeFrom);
            Double BC = Math.abs(latitudeTo - latitudeFrom);
            Double cost = Math.sqrt(Math.pow(AC, 2) + Math.pow(BC, 2));
            availablePoints.put(transition.getTo(), cost);

        }
        point.setAvailablePoints(availablePoints);

        return point;
    }

    @Override
    public void update(Point point) throws InvalidParametersException, ResourceNotFoundException, ValidationException {
        if (point == null) {
            throw new InvalidParametersException("Exception when try to update Point - object is null");
        }
        if (point.getId() == null) {
            throw new InvalidParametersException("Exception when try to update Point = id is null");
        }
        findById(point.getId());

        if (!isValid(point)) {
            throw new ValidationException("Exception when try to update Point - object is not valid");
        }
        POINT_REPOSITORY.update(point);
    }

    @Override
    public void delete(Point point) throws InvalidParametersException, ResourceNotFoundException {
        if (point == null) {
            throw new InvalidParametersException(String.format(exeptionStub, "delete", "object is null"));
        }
        if (point.getId() == null) {
            throw new InvalidParametersException(String.format(exeptionStub, "delete", "id is null"));
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

    @Override
    public Long getIdByName(String pointName) throws Exception {
        return PointRepository.findIdByName(pointName)
                .orElseThrow(() -> new InvalidParametersException("No point with this name"));
}
