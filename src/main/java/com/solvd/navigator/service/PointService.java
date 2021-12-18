package com.solvd.navigator.service;

import com.solvd.navigator.domain.Point;
import com.solvd.navigator.domain.exception.EntityNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;

import java.util.List;

public interface PointService {

    void create(Point point, Long districtId) throws EntityNotValidException, InvalidParametersException, ResourceNotFoundException;

    List<Point> findAll() throws ResourceNotFoundException;

    Point findById(Long id) throws InvalidParametersException, ResourceNotFoundException;

    void update(Point point) throws InvalidParametersException, ResourceNotFoundException, EntityNotValidException;

    void delete(Point point) throws InvalidParametersException, ResourceNotFoundException;
}
