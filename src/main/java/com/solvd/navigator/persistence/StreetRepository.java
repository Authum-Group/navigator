package com.solvd.navigator.persistence;

import com.solvd.navigator.domain.Street;

import java.util.List;

public interface StreetRepository {

    void create(Street street);

    List<Street> findAll();

    Street findById(Long id);

    void update(Street street);

    void delete(Street street);

}
