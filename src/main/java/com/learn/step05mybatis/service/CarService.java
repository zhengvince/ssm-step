package com.learn.step05mybatis.service;

import com.learn.step05mybatis.entity.Car;

import java.util.List;

/**
 * 业务层 接口
 * Created by Vince on 2016/2/22.
 */
public interface CarService {
    int insert(Car car);

    int update(Car car);

    int delete(Integer id);

    List<Car> selectAll();

    int countAll();

    Car findById(Integer id);
}
