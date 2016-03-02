package com.learn.step01spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring的第一课，基础步骤
 * Author: vince
 * Create: 2016-02-20 下午4:38
 */
public class HelloSpring {
    public static void main(String[] args){

        //创建ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");


        //从容器中获取Bean
        SpringUser springUser =  context.getBean(SpringUser.class);

        //调用方法
        springUser.setUserName("张三");

        System.out.println(springUser.sayHello());
        System.out.println(springUser.sayHelloToUser());


    }
}