package com.learn.step06ehcache.service;

import com.learn.step06ehcache.entity.User;

import java.util.List;

/**
 * 业务层 接口
 * Created by Vince on 2016/2/22.
 */
public interface UserService {
    int insert(User user);

    int update(User user);

    int delete(Integer id);

    List<User> selectAll();

    int countAll();

    User findById(Integer id);
}
