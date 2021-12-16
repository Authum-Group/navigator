package com.solvd.navigator.persistence;

import java.util.Optional;

public interface PointRepository {

    Optional<Long> findIdByName(String point1) throws Exception;

}
