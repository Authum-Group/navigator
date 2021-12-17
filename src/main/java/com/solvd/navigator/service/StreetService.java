package com.solvd.navigator.service;

import com.solvd.navigator.domain.Street;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;
import com.solvd.navigator.domain.exception.ValidationException;

import java.util.List;

public interface StreetService {

    void create(Street street) throws InvalidParametersException, ValidationException;

    List<Street> findAll() throws ResourceNotFoundException;

    Street findById(Long id) throws InvalidParametersException, ResourceNotFoundException;

    void update(Street street) throws InvalidParametersException, ValidationException, ResourceNotFoundException;

    void delete(Street street) throws InvalidParametersException, ResourceNotFoundException;
}
