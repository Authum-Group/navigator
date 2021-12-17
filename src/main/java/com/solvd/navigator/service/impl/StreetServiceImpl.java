package com.solvd.navigator.service.impl;

import com.solvd.navigator.domain.Point;
import com.solvd.navigator.domain.Street;
import com.solvd.navigator.domain.exception.EntityIsNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;
import com.solvd.navigator.persistence.StreetRepository;
import com.solvd.navigator.persistence.mybatisImpl.StreetRepositoryMyBatisImpl;
import com.solvd.navigator.service.PointService;
import com.solvd.navigator.service.StreetService;

import java.util.List;
import java.util.stream.Collectors;

public class StreetServiceImpl implements StreetService {

    private static final StreetRepository STREET_REPOSITORY = new StreetRepositoryMyBatisImpl();
    private static final PointService POINT_SERVICE = new PointServiceImpl();
    private static final String exceptionStub = "Exception when try to %s Street - %s";

    @Override
    public void create(Street street) throws InvalidParametersException, EntityIsNotValidException {
        if (street == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "create", "street's object is null"));
        }
        if (!isValid(street)) {
            throw new EntityIsNotValidException(String.format(exceptionStub, "create", "street's object is not valid"));
        }
        street.setId(null);
        STREET_REPOSITORY.create(street);

        for (Point streetPoint : street.getPoints()) {
            POINT_SERVICE.create(streetPoint);
        }
    }

    @Override
    public List<Street> findAll() throws ResourceNotFoundException {
        List<Street> streets = STREET_REPOSITORY.findAll();
//        if (streets.size() <= 0) {
//            throw new ResourceNotFoundException(String.format(exceptionStub, "findAll", "there are no streets in db"));
//        }
        List<Point> points = POINT_SERVICE.findAll(); // TODO Optimization
        for (Street street : streets) {
            street.setPoints(points.stream()
                    .filter(point -> {
                                return street.getId().equals(point.getStreet().getId());
                            }
                    )
                    .collect(Collectors.toList()));
        }
        return streets;
    }

    @Override
    public Street findById(Long id) throws InvalidParametersException, ResourceNotFoundException {
        if (id == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "find by id", "id is null"));
        }
        Street street = STREET_REPOSITORY.findById(id);
        if (street == null) {
            throw new ResourceNotFoundException(String.format(exceptionStub, "find by id", "there are no street with id=" + id));
        }
        street.setPoints(POINT_SERVICE.findAll().stream()
                .filter(point -> id.equals(point.getStreet().getId())).collect(Collectors.toList())
        );
        return street;
    }

    @Override
    public void update(Street street) throws InvalidParametersException, EntityIsNotValidException, ResourceNotFoundException {
        if (street == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "update", "street's object is null"));
        }
        if (street.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "update", "street's id is null"));
        }
        if (!isValid(street)) {
            throw new EntityIsNotValidException(String.format(exceptionStub, "update", "street's object is not valid"));
        }
        findById(street.getId()); // TODO Change way to check object in db
        STREET_REPOSITORY.update(street);

        for (Point point : street.getPoints()) {
            if (!point.equals(POINT_SERVICE.findById(point.getId()))) {
                POINT_SERVICE.update(point);
            }
        }
    }

    @Override
    public void delete(Street street) throws InvalidParametersException, ResourceNotFoundException {
        if (street == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "street's object is null"));
        }
        if (street.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "street object's id is null"));
        }
        findById(street.getId());
        STREET_REPOSITORY.delete(street);
    }

    private boolean isValid(Street street) {
        return street.getName() != null && street.getDistrict() != null;
    }
}
