package com.learn.step01spring;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * spring的测试类
 * Author: vince
 * Create: 2016-02-29 下午11:31
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class HelloSpringTest {

    @Autowired
    private SpringUser springUser;

    @Test
    public void testSayHello() {
        Assert.assertEquals("Hello World!", springUser.sayHello());
    }


}