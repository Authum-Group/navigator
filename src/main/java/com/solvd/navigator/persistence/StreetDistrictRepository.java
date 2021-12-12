package com.solvd.navigator.persistence;

import com.solvd.navigator.domain.Street;

public interface StreetDistrictRepository {

    void create(Street street);

    void update(Street street);

    void delete(Street street);

}
