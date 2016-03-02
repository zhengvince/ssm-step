package com.learn.step01spring;

import org.springframework.stereotype.Component;

/**
 * 用于spring测试User类
 * Author: vince
 * Create: 2016-02-29 下午11:12
 */
@Component
public class SpringUser {
    private String userName;

    public void setUserName(String name){
        this.userName=name;
    }

    public String sayHello(){
        return "Hello World!";
    }
    public String sayHelloToUser(){
        return   "Hello " + userName;
    }
}
