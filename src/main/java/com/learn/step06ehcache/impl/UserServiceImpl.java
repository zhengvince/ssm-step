package com.learn.step06ehcache.impl;

import com.learn.step06ehcache.entity.User;
import com.learn.step06ehcache.mapper.UserMapper;
import com.learn.step06ehcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 业务层 实现
 * Created by Vince on 2016/2/22.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;


    /**
     *
     * 使用缓存,则不用再访问数据库
     */
//    @Cacheable(value = "myCache" ,key="#id + 'findById'")
    @Cacheable(value = "myCache" )
    @Override
    public User findById(Integer id) {
        System.out.println("@@@@@=>select from db");
        return this.userMapper.findById(id);

    }
    @Override
    public int insert(User user) {
        return this.userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return this.userMapper.update(user);

    }

    @Override
    public int delete(Integer id) {
        return this.userMapper.delete(id);

    }

    @Override
    public List<User> selectAll() {
        return this.userMapper.selectAll();

    }

    @Override
    public int countAll() {
        return this.userMapper.countAll();

    }

}
