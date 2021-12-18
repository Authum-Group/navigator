package com.solvd.navigator.service.impl;

import com.solvd.navigator.domain.City;
import com.solvd.navigator.domain.District;
import com.solvd.navigator.domain.exception.EntityIsNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;
import com.solvd.navigator.persistence.CityRepository;
import com.solvd.navigator.persistence.mybatisImpl.CityRepositoryMyBatisImpl;
import com.solvd.navigator.service.CityService;
import com.solvd.navigator.service.DistrictService;

import java.util.List;
import java.util.stream.Collectors;

public class CityServiceImpl implements CityService {

    private static final CityRepository CITY_REPOSITORY = new CityRepositoryMyBatisImpl();
    private static final DistrictService DISTRICT_SERVICE = new DistrictServiceImpl();
    private static final String exceptionStub = "Exception when try to %s City - %s";

    @Override
    public void create(City city) throws InvalidParametersException, EntityIsNotValidException {
        if (city == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "create", "city's object is null"));
        }
        if (!isValid(city)) {
            throw new EntityIsNotValidException(String.format(exceptionStub, "create", "city's object is not valid"));
        }
        city.setId(null);
        CITY_REPOSITORY.create(city);

        for (District district : city.getDistricts()) {
            DISTRICT_SERVICE.create(district);
        }
    }

    @Override
    public List<City> findAll() throws ResourceNotFoundException {
        List<City> cities = CITY_REPOSITORY.findAll();

        List<District> districts = DISTRICT_SERVICE.findAll();
        for (City city : cities) {
            city.setDistricts(districts.stream()
                    .filter(district -> {
                                return city.getId().equals(district.getCity().getId());
                            }
                    )
                    .collect(Collectors.toList()));
        }
        return cities;
    }

    @Override
    public City findById(Long id) throws InvalidParametersException, ResourceNotFoundException {
        if (id == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "find by id", "id is null"));
        }
        City city = CITY_REPOSITORY.findById(id);
        if (city == null) {
            throw new ResourceNotFoundException(String.format(exceptionStub, "find by id", "there are no city with id=" + id));
        }
        city.setDistricts(DISTRICT_SERVICE.findAll().stream()
                .filter(district -> id.equals(district.getCity().getId()))
                .collect(Collectors.toList())
        );
        return city;
    }

    @Override
    public void update(City city) throws InvalidParametersException, EntityIsNotValidException, ResourceNotFoundException {
        if (city == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "update", "city's object is null"));
        }
        if (city.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "update", "city's id is null"));
        }
        if (!isValid(city)) {
            throw new EntityIsNotValidException(String.format(exceptionStub, "update", "city's object is not valid"));
        }
        findById(city.getId());
        CITY_REPOSITORY.update(city);

        for (District district : city.getDistricts()) {
            if (!district.equals(DISTRICT_SERVICE.findById(district.getId()))) {
                DISTRICT_SERVICE.update(district);
            }
        }
    }

    @Override
    public void delete(City city) throws InvalidParametersException, ResourceNotFoundException {
        if (city == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "city's object is null"));
        }
        if (city.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "city object's id is null"));
        }
        findById(city.getId());
        CITY_REPOSITORY.delete(city);
    }

    private boolean isValid(City city) {
        return city.getName() != null && city.getRegion() != null;
    }
}
