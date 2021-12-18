package com.solvd.navigator.service;

import com.solvd.navigator.domain.Country;
import com.solvd.navigator.domain.exception.EntityIsNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;

import java.util.List;

public interface CountryService {

    void create(Country country) throws InvalidParametersException, EntityIsNotValidException, ResourceNotFoundException;

    List<Country> findAll() throws ResourceNotFoundException;

    Country findById(Long id) throws InvalidParametersException, ResourceNotFoundException;

    void update(Country country) throws InvalidParametersException, EntityIsNotValidException, ResourceNotFoundException;

    void delete(Country country) throws InvalidParametersException, ResourceNotFoundException;
}
