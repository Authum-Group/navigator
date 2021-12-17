package com.solvd.navigator.persistence.mybatisImpl;

import com.solvd.navigator.domain.Street;
import com.solvd.navigator.persistence.MyBatisSessionHolder;
import com.solvd.navigator.persistence.StreetRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StreetRepositoryMyBatisImpl implements StreetRepository {

    @Override
    public void create(Street street) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            StreetRepository streetRepository = session.getMapper(StreetRepository.class);
            streetRepository.create(street);
        }
    }

    @Override
    public List<Street> findAll() {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            StreetRepository streetRepository = session.getMapper(StreetRepository.class);
            return streetRepository.findAll();
        }
    }

    @Override
    public Street findById(Long id) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            StreetRepository streetRepository = session.getMapper(StreetRepository.class);
            return streetRepository.findById(id);
        }
    }

    @Override
    public void update(Street street) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            StreetRepository streetRepository = session.getMapper(StreetRepository.class);
            streetRepository.update(street);
        }
    }

    @Override
    public void delete(Street street) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            StreetRepository streetRepository = session.getMapper(StreetRepository.class);
            streetRepository.delete(street);
        }
    }
}
