package com.solvd.navigator.persistence.mybatisImpl;

import com.solvd.navigator.domain.Country;
import com.solvd.navigator.persistence.CountryRepository;
import com.solvd.navigator.persistence.MyBatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CountryRepositoryMyBatisImpl implements CountryRepository {

    @Override
    public void create(Country country) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CountryRepository countryRepository = session.getMapper(CountryRepository.class);
            countryRepository.create(country);
        }
    }

    @Override
    public List<Country> findAll() {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CountryRepository countryRepository = session.getMapper(CountryRepository.class);
            return countryRepository.findAll();
        }
    }

    @Override
    public Country findById(Long id) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CountryRepository countryRepository = session.getMapper(CountryRepository.class);
            return countryRepository.findById(id);
        }
    }

    @Override
    public void update(Country country) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CountryRepository countryRepository = session.getMapper(CountryRepository.class);
            countryRepository.update(country);
        }
    }

    @Override
    public void delete(Country country) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CountryRepository countryRepository = session.getMapper(CountryRepository.class);
            countryRepository.delete(country);
        }
    }

}
