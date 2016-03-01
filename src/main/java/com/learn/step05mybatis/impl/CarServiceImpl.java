package com.learn.step05mybatis.impl;

import com.learn.step05mybatis.mapper.CarMapper;
import com.learn.step05mybatis.entity.Car;
import com.learn.step05mybatis.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 业务层 实现
 * Created by Vince on 2016/2/22.
 */

@Service
@Transactional
public class CarServiceImpl implements CarService{

    @Autowired(required = false)
    private CarMapper carMapper;

    @Override
    public int insert(Car car) {
        return this.carMapper.insert(car);
    }

    @Override
    public int update(Car car) {
        return this.carMapper.update(car);

    }

    @Override
    public int delete(Integer id) {
        return this.carMapper.delete(id);

    }

    @Override
    public List<Car> selectAll() {
        return this.carMapper.selectAll();

    }

    @Override
    public int countAll() {
        return this.carMapper.countAll();

    }

    @Override
    public Car findById(Integer id) {
        return this.carMapper.findById(id);

    }
}
