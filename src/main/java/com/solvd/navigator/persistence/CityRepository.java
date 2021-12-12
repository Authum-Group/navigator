package com.solvd.navigator.persistence;

import com.solvd.navigator.domain.City;

import java.util.List;

public interface CityRepository {

    void create(City city);

    List<City> findAll();

    City findById(Long id);

    void update(City city);

    void delete(City city);

}
