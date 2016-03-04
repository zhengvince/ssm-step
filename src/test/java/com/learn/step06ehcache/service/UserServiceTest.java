package com.learn.step06ehcache.service;

import com.learn.step06ehcache.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * 测试ehcache
 * Create by vince in 2016-03-01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    User user;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {
        user.setUsername("linda");
        userService.insert(user);
    }

    @Test
    public void testUpdate() throws Exception {
        user.setId(2);
        user.setAge(39);
        userService.update(user);
    }

    @Test
    public void testDelete() throws Exception {
        userService.delete(3);
    }

    @Test
    public void testSelectAll() throws Exception {
        List<User> users = userService.selectAll();
        System.out.println("      @@@========>"+users.toString());

    }

    @Test
    public void testCountAll() throws Exception {
        System.out.println("      @@@========>"+userService.countAll());

    }

    @Test
    public void testFindById() throws Exception {
        user = userService.findById(1);
        System.out.println("      @@@========>"+user.toString());
    }

    @Test
    public void testFindByUserName() throws Exception {
        user = userService.findByUsername("zhaoliu");
        System.out.println("      @@@========>"+user.toString());
    }
}