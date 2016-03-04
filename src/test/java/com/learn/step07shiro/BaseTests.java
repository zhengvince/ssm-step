package com.learn.step07shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-26
 * <p>Version: 1.0
 */
public abstract class BaseTests {

    public static Logger log = LoggerFactory.getLogger(BaseTests.class);

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
        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            //收集用户的主要信息和凭据，来自GUI中的特定的方式
            //如包含用户名/密码的HTML表格，X509证书，OpenID，等。
            //我们将使用用户名/密码的例子因为它是最常见的。.
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);

            //支持'remember me' (无需配置，内建的!):
            token.setRememberMe(true);
            try {
                //5、登录
                currentUser.login(token);
                //无异常，说明就是我们想要的!
                log.info( "User [" + currentUser.getPrincipal() + "] 登录成功." );
            } catch (UnknownAccountException uae) {
                //username 不存在，给个错误提示?
                log.debug("用户名不存在" + uae);
            } catch (IncorrectCredentialsException ice) {
                //password 不匹配，再输入?
                log.debug("密码错误" + ice);
            } catch (LockedAccountException lae) {
                //账号锁住了，不能登入。给个提示?
                log.debug("账号多次错误,被锁定" + lae);

            }
            //  ... 更多类型异常 ...
            catch (AuthenticationException ae) {
                //未考虑到的问题 - 错误?
                log.debug("登陆错误" + ae);
            }

        }
    }

    public Subject subject() {
        return SecurityUtils.getSubject();
    }
}
