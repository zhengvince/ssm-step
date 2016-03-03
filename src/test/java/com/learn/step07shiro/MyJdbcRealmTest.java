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
public class MyJdbcRealmTest extends BaseTests {


    @Test
    public void testShiroJdbcRealm() {
        String iniConfigPath = "classpath:com/learn/step07shiro/shiro-jdbc-realm.ini";
        String username = "zhangsan";
        String password = "333333";
        login(iniConfigPath, username, password);
    }
}