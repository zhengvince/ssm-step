package com.learn.step05mybatis.mapper;

import com.learn.step05mybatis.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层的DAO
 * Created by Vince on 2016/2/22.
 */
@Repository
public interface CarMapper {

         int insert(Car car);

         int update(Car car);

         int delete(Integer id);

         List<Car> selectAll();

         int countAll();

         Car findById(Integer id);

}
