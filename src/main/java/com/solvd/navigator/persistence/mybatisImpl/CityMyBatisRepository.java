package com.solvd.navigator.persistence.mybatisImpl;

import com.solvd.navigator.domain.City;
import com.solvd.navigator.persistence.CityRepository;
import com.solvd.navigator.persistence.MyBatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CityMyBatisRepository implements CityRepository {


    @Override
    public void create(City city) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CityRepository cityRepository = session.getMapper(CityRepository.class);
            cityRepository.create(city);
        }
    }

    @Override
    public List<City> findAll() {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CityRepository cityRepository = session.getMapper(CityRepository.class);
            return cityRepository.findAll();
        }
    }

    @Override
    public City findById(Long id) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CityRepository cityRepository = session.getMapper(CityRepository.class);
            return cityRepository.findById(id);
        }
    }

    @Override
    public void update(City city) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CityRepository cityRepository = session.getMapper(CityRepository.class);
            cityRepository.update(city);
        }
    }

    @Override
    public void delete(City city) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CityRepository cityRepository = session.getMapper(CityRepository.class);
            cityRepository.delete(city);
        }
    }

}
