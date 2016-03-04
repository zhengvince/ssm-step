package com.learn.step06ehcache.mapper;

import com.learn.step06ehcache.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层的DAO
 * Created by Vince on 2016/2/22.
 */
@Repository
public interface UserMapper {

         int insert(User user);

         int update(User user);

         int delete(Integer id);

         List<User> selectAll();

         int countAll();

         User findById(Integer id);
         User findByUsername(String username);



}
