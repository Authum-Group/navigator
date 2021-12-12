package com.solvd.navigator.persistence;

import com.solvd.navigator.domain.Country;

import java.util.List;

public interface CountryRepository {

    void create(Country country);

    List<Country> findAll();

    Country findById(Long id);

    void update(Country country);

    void delete(Country country);

}
