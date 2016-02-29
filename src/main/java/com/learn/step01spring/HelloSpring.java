package com.learn.step01spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ${DISCRIPTION}
 * Author: vince
 * Create: 2016-02-20 下午4:38
 */
public class HelloSpring {
    public static void main(String[] args){

        //创建ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");


        //从容器中获取Bean
        User user =  context.getBean(User.class);

        //调用方法
        user.setUserName("张三");

        System.out.println(user.sayHello());
        System.out.println(user.sayHelloToUser());


    }
}