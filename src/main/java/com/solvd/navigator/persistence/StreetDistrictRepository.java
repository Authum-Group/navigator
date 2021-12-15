package com.solvd.navigator.persistence;

import org.apache.ibatis.annotations.Param;

public interface StreetDistrictRepository {

    void create(@Param("streetId") Long streetId, @Param("districtId") Long districtId);

    void update(@Param("streetId") Long streetId, @Param("districtId") Long districtId);

    void delete(@Param("streetId") Long streetId, @Param("districtId") Long districtId);

    //    List<Region> findAll();
    //
    //    Region findById(Long id);

}
