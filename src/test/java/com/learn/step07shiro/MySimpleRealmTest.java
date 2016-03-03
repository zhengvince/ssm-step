package com.learn.step07shiro;

import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * ToDo...
 * Created by Vince on 2016/3/3.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class MySimpleRealmTest extends BaseTests {

    @Test
    public void testShiroHelloWorld() {
        String iniConfigPath = "classpath:com/learn/step07shiro/shiro-users.ini";
        String username = "zhangsan";
        String password = "123456";
        login(iniConfigPath, username, password);
    }

    @Test
    public void testShiroSimpleRealm() {
        String iniConfigPath = "classpath:com/learn/step07shiro/shiro-simple-realm.ini";
        String username = "lisi";
        String password = "qqq";
        login(iniConfigPath, username, password);
    }


}