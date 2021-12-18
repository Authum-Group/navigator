package com.solvd.navigator.service;

import com.solvd.navigator.domain.District;
import com.solvd.navigator.domain.exception.EntityIsNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;

import java.util.List;

public interface DistrictService {

    void create(District district) throws InvalidParametersException, EntityIsNotValidException;

    List<District> findAll() throws ResourceNotFoundException;

    District findById(Long id) throws InvalidParametersException, ResourceNotFoundException;

    void update(District district) throws InvalidParametersException, EntityIsNotValidException, ResourceNotFoundException;

    void delete(District district) throws InvalidParametersException, ResourceNotFoundException;
}
