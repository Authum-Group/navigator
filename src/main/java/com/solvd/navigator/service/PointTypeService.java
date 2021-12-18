package com.solvd.navigator.service;

import com.solvd.navigator.domain.PointType;
import com.solvd.navigator.domain.exception.EntityNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;

import java.util.List;

public interface PointTypeService {

    void create(PointType pointType) throws EntityNotValidException, InvalidParametersException, ResourceNotFoundException;

    List<PointType> findAll() throws ResourceNotFoundException;

    PointType findById(Long id) throws InvalidParametersException, ResourceNotFoundException;

    void update(PointType pointType) throws InvalidParametersException, ResourceNotFoundException, EntityNotValidException;

    void delete(PointType pointType) throws InvalidParametersException, ResourceNotFoundException;
}
