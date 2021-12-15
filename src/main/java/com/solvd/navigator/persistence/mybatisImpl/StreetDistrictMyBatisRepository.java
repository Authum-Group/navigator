package com.solvd.navigator.persistence.mybatisImpl;

import com.solvd.navigator.persistence.MyBatisSessionHolder;
import com.solvd.navigator.persistence.StreetDistrictRepository;
import org.apache.ibatis.session.SqlSession;

public class StreetDistrictMyBatisRepository implements StreetDistrictRepository {

    @Override
    public void create(Long streetId, Long districtId) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            StreetDistrictRepository streetDistrictRepository = session.getMapper(StreetDistrictRepository.class);
            streetDistrictRepository.create(streetId, districtId);
        }
    }

    @Override
    public void update(Long streetId, Long districtId) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            StreetDistrictRepository streetDistrictRepository = session.getMapper(StreetDistrictRepository.class);
            streetDistrictRepository.update(streetId, districtId);
        }
    }

    @Override
    public void delete(Long streetId, Long districtId) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            StreetDistrictRepository streetDistrictRepository = session.getMapper(StreetDistrictRepository.class);
            streetDistrictRepository.delete(streetId, districtId);
        }
    }
}
