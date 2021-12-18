package com.solvd.navigator.service.impl;

import com.solvd.navigator.domain.Country;
import com.solvd.navigator.domain.Region;
import com.solvd.navigator.domain.exception.EntityIsNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;
import com.solvd.navigator.persistence.CountryRepository;
import com.solvd.navigator.persistence.mybatisImpl.CountryRepositoryMyBatisImpl;
import com.solvd.navigator.service.CountryService;
import com.solvd.navigator.service.RegionService;

import java.util.List;
import java.util.stream.Collectors;

public class CountryServiceImpl implements CountryService {

    private static final CountryRepository COUNTRY_REPOSITORY = new CountryRepositoryMyBatisImpl();
    private static final RegionService REGION_SERVICE = new RegionServiceImpl();
    private static final String exceptionStub = "Exception when try to %s Country - %s";


    @Override
    public void create(Country country) throws InvalidParametersException, EntityIsNotValidException, ResourceNotFoundException {
        if (country == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "create", "country's object is null"));
        }
        if (!isValid(country)) {
            throw new EntityIsNotValidException(String.format(exceptionStub, "create", "country's object is not valid"));
        }
        country.setId(null);
        COUNTRY_REPOSITORY.create(country);
        if (country.getRegions() == null) {
            return;
        }
        for (Region region : country.getRegions()) {
            REGION_SERVICE.create(region, country.getId());
        }
    }

    @Override
    public List<Country> findAll() throws ResourceNotFoundException {
        List<Country> countries = COUNTRY_REPOSITORY.findAll();
        List<Region> regions = REGION_SERVICE.findAll();
        for (Country country : countries) {
            country.setRegions(regions.stream()
                    .filter(region -> country.getId().equals(region.getCountry().getId()))
                    .collect(Collectors.toList()));
        }
        return countries;
    }

    @Override
    public Country findById(Long id) throws InvalidParametersException, ResourceNotFoundException {
        if (id == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "find by id", "id is null"));
        }
        Country country = COUNTRY_REPOSITORY.findById(id);
        if (country == null) {
            throw new ResourceNotFoundException(String.format(exceptionStub, "find by id", "there are no country with id=" + id));
        }
        country.setRegions(REGION_SERVICE.findAll().stream()
                .filter(region -> id.equals(region.getCountry().getId()))
                .collect(Collectors.toList())
        );
        return country;
    }

    @Override
    public void update(Country country) throws InvalidParametersException, EntityIsNotValidException, ResourceNotFoundException {
        if (country == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "update", "country's object is null"));
        }
        if (country.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "update", "country's id is null"));
        }
        if (!isValid(country)) {
            throw new EntityIsNotValidException(String.format(exceptionStub, "update", "country's object is not valid"));
        }
        findById(country.getId());
        COUNTRY_REPOSITORY.update(country);

        for (Region region : country.getRegions()) {
            if (!region.equals(REGION_SERVICE.findById(region.getId()))) {
                REGION_SERVICE.update(region);
            }
        }
    }

    @Override
    public void delete(Country country) throws InvalidParametersException, ResourceNotFoundException {
        if (country == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "country's object is null"));
        }
        if (country.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "country object's id is null"));
        }
        findById(country.getId());
        COUNTRY_REPOSITORY.delete(country);
    }

    private boolean isValid(Country country) {
        return country.getName() != null;
    }
}
