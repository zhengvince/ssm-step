package com.learn.step05mybatis.service;

import com.learn.step05mybatis.entity.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * 测试mybatis
 * Create by vince in 2016-03-01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CarServiceTest {

    @Autowired
    CarService carService;

    @Autowired
    Car car;

    public static Logger log = LoggerFactory.getLogger(CarService.class);


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {
        car.setBland("别克");
        car.setColor("金色");
        carService.insert(car);
    }

    @Test
    public void testUpdate() throws Exception {
        car.setId(2);
        car.setColor("神奇的颜色");
        carService.update(car);

    }

    @Test
    public void testDelete() throws Exception {
        carService.delete(3);

    }

    @Test
    public void testSelectAll() throws Exception {
        List<Car> cars = carService.selectAll();
        log.debug(cars.toString());

    }

    @Test
    public void testCountAll() throws Exception {
        carService.countAll();

    }

    @Test
    public void testFindById() throws Exception {
        carService.findById(1);

    }
}