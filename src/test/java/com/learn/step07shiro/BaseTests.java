package com.learn.step07shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-26
 * <p>Version: 1.0
 */
public abstract class BaseTests {



    //测试后解绑subject，防止冲突
    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();
    }

    protected void login(String configFile, String username, String password) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory(configFile);

        //2、分析 INI 文件并根据配置文件返回一个 SecurityManager 实例。
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();

        //3、在这个简单示例中，我们将 SecurityManager 设置成了static (memory) singleton，可以通过 JVM 访问
        //   但在其它成熟的应用环境中，通常会将 SecurityManager 放在程序指定的存储中（如在 Spring、Guice、 JBoss DI 容器实例）中。
        SecurityUtils.setSecurityManager(securityManager);

        //4、得到当前用户
        Subject currentUser  = SecurityUtils.getSubject();


        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        //5、登录
        currentUser.login(token);
    }

    public Subject subject() {
        return SecurityUtils.getSubject();
    }
}
