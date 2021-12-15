package com.solvd.navigator.persistence;

import com.solvd.navigator.domain.House;

import java.util.List;

public interface HouseRepository {

    void create(House house);

    List<House> findAll();

    House findById(Long id);

    void update(House house);

    void delete(House house);

}
