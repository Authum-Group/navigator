package com.solvd.navigator.persistence.mybatisImpl;

import com.solvd.navigator.domain.House;
import com.solvd.navigator.persistence.HouseRepository;
import com.solvd.navigator.persistence.MyBatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class HouseMyBatisRepository implements HouseRepository {

    @Override
    public void create(House house) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            HouseRepository houseRepository = session.getMapper(HouseRepository.class);
            houseRepository.create(house);
        }
    }

    @Override
    public List<House> findAll() {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            HouseRepository houseRepository = session.getMapper(HouseRepository.class);
            return houseRepository.findAll();
        }
    }

    @Override
    public House findById(Long id) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            HouseRepository houseRepository = session.getMapper(HouseRepository.class);
            return houseRepository.findById(id);
        }
    }

    @Override
    public void update(House house) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            HouseRepository houseRepository = session.getMapper(HouseRepository.class);
            houseRepository.update(house);
        }
    }

    @Override
    public void delete(House house) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            HouseRepository houseRepository = session.getMapper(HouseRepository.class);
            houseRepository.delete(house);
        }
    }

}
