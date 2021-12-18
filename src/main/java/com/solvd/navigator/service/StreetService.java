package com.solvd.navigator.service;

import com.solvd.navigator.domain.Street;
import com.solvd.navigator.domain.exception.EntityIsNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;

import java.util.List;

public interface StreetService {

    void create(Street street, Long districtId) throws InvalidParametersException, EntityIsNotValidException, ResourceNotFoundException;

    List<Street> findAll() throws ResourceNotFoundException;

    Street findById(Long id) throws InvalidParametersException, ResourceNotFoundException;

    void update(Street street) throws InvalidParametersException, EntityIsNotValidException, ResourceNotFoundException;

    void delete(Street street) throws InvalidParametersException, ResourceNotFoundException;
}
