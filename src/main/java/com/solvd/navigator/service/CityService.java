package com.solvd.navigator.service;

import com.solvd.navigator.domain.City;
import com.solvd.navigator.domain.exception.EntityNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;

import java.util.List;

public interface CityService {
    void create(City city, Long regionId) throws InvalidParametersException, EntityNotValidException, ResourceNotFoundException;

    List<City> findAll() throws ResourceNotFoundException;

    City findById(Long id) throws InvalidParametersException, ResourceNotFoundException;

    void update(City city) throws InvalidParametersException, EntityNotValidException, ResourceNotFoundException;

    void delete(City city) throws InvalidParametersException, ResourceNotFoundException;
}
