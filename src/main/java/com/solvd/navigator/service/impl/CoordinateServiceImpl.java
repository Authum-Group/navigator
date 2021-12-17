package com.solvd.navigator.service.impl;

import com.solvd.navigator.service.CoordinateService;

public class CoordinateServiceImpl implements CoordinateService {
//
//    private static final CoordinateRepository COORDINATE_REPOSITORY = new CoordinateMyBatisRepository();
//
//    @Override
//    public void create(Coordinate coordinate) throws ValidationException, InvalidParametersException {
//        if (coordinate == null) {
//            throw new InvalidParametersException("Exception when try to create Coordinate - object is null");
//        }
//        if (!isValid(coordinate)) {
//            throw new ValidationException("Exception when try to create coordinate - data is not valid");
//        }
//        coordinate.setId(null);
//        COORDINATE_REPOSITORY.create(coordinate);
//    }
//
//    @Override
//    public List<Coordinate> findAll() throws ResourceNotFoundException {
//        List<Coordinate> coordinates = COORDINATE_REPOSITORY.findAll();
//        if (coordinates.size() <= 0) {
//            throw new ResourceNotFoundException("Exception when try to get all coordinates - there are no any of coordinate");
//        }
//        return coordinates;
//    }
//
//    @Override
//    public Coordinate findById(Long id) throws InvalidParametersException, ResourceNotFoundException {
//        if (id == null || id < 0) {
//            throw new InvalidParametersException("Exception when try to find Coordinate by id - invalid id");
//        }
//        Coordinate coordinate = COORDINATE_REPOSITORY.findById(id);
//        if (coordinate == null) {
//            throw new ResourceNotFoundException("Exception when try to find Coordinate by id - there are no such Coordinate with id=" + id.toString());
//        }
//        return COORDINATE_REPOSITORY.findById(id);
//    }
//
//    @Override
//    public void update(Coordinate coordinate) throws ValidationException, InvalidParametersException, ResourceNotFoundException {
//        if (coordinate == null) {
//            throw new InvalidParametersException("Exception when try to update Coordinate - object is null");
//        }
//        if (coordinate.getId() == null) {
//            throw new ValidationException("Exception when try to update Coordinate - object has not id");
//        }
//        findById(coordinate.getId()); // TODO Check if this is a correct
//        if (!isValid(coordinate)) {
//            throw new ValidationException("Exception when try to update Coordinate - object is not valid");
//        }
//        COORDINATE_REPOSITORY.update(coordinate);
//    }
//
//    @Override
//    public void delete(Coordinate coordinate) throws ValidationException, ResourceNotFoundException, InvalidParametersException {
//        if (coordinate == null) {
//            throw new InvalidParametersException("Exception when try to delete Coordinate - object is null");
//        }
//        if (coordinate.getId() == null) {
//            throw new ValidationException("Exception when try to delete Coordinate - object has not id");
//        }
//        if (findById(coordinate.getId()) == null) {
//            throw new ResourceNotFoundException("Exception when try to delete Coordinate - there are no such onject with id= " + coordinate.getId().toString());
//        }
//        COORDINATE_REPOSITORY.delete(coordinate);
//    }
//
//    private boolean isValid(Coordinate coordinate) {
//        return coordinate.getLatitude() != null && coordinate.getLongitude() != null && coordinate.getLongitude() >= 0 && coordinate.getLatitude() >= 0;
//    }
}
