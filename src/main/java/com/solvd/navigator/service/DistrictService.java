package com.solvd.navigator.service;

import com.solvd.navigator.domain.District;
import com.solvd.navigator.domain.exception.EntityNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;

import java.util.List;

public interface DistrictService {

    void create(District district, Long cityId) throws InvalidParametersException, EntityNotValidException, ResourceNotFoundException;

    List<District> findAll() throws ResourceNotFoundException;

    District findById(Long id) throws InvalidParametersException, ResourceNotFoundException;

    void update(District district) throws InvalidParametersException, EntityNotValidException, ResourceNotFoundException;

    void delete(District district) throws InvalidParametersException, ResourceNotFoundException;
}
