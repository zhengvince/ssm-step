package com.learn.step06ehcache.controller;

import com.learn.step06ehcache.entity.User;
import com.learn.step06ehcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用于测试mvc的类
 * Created by Vince on 2016/3/1.
 */
@Controller
@RequestMapping("/learn/ehcache")
public class ehcacheController {

    @Autowired
    UserService userService;

    /**
     * 测试时，访问index.jsp之后点击各个链接并依次观察控制台输出即可
     * 缓存有效果的特征是：第二次查询数据时不会访问数据库（即不打印日志）
     */
    @RequestMapping(value= "/get/{id}", method=RequestMethod.GET)
    public String get(@PathVariable Integer id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "learn/ehcache/user";
    }



}
