package com.learn.step07shiro;

/**
 * 这是shiro的第一课,基础用法,
 * 详见https://waylau.gitbooks.io/apache-shiro-1-2-x-reference/content/I.%20Overview%20总览/2.%20Tutorial%20教程.html
 * Create by vince in 2016-03-03
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tutorial {


    //日志
    private static final transient Logger log = LoggerFactory.getLogger(Tutorial.class);


    public static void main(String[] args) {
        log.info("===== 我的第一个 Shiro 程序======");

        //1.加载配置文件,生成SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:com/learn/step07shiro/shiro-tutorial.ini");
        //2.从工厂生成securityManager
        SecurityManager securityManager = factory.getInstance();
        //3.在这个简单示例中，我们将 SecurityManager 设置成了static (memory) singleton，可以通过 JVM 访问
        //  但在其它成熟的应用环境中，通常会将 SecurityManager 放在程序指定的存储中（如在 Spring、Guice、 JBoss DI 容器实例）中。
        SecurityUtils.setSecurityManager(securityManager);


        //4.获取当前执行用户:
        Subject currentUser = SecurityUtils.getSubject();

        // 做点跟 Session 相关的事
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            log.info("Retrieved the correct value! [" + value + "]");
        }

        // 登录当前用户检验角色和权限
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                log.info("没有这个用户名" + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                log.info( token.getPrincipal() + " 的密码不正确");
            } catch (LockedAccountException lae) {
                log.info("用户 " + token.getPrincipal() + " 已被锁定.  " +
                        "请联系管理员解锁.");
            }
            // ... 捕获更多异常
            catch (AuthenticationException ae) {
                //无定义?错误?
            }
        }

        //说出他们是谁:
        //打印主要识别信息 (本例是 username):
        log.info("User [" + currentUser.getPrincipal() + "] 登录成功.");

        //测试角色:
        if (currentUser.hasRole("headmaster")) {
            log.info("校长好,学校是你的地盘");
        } else {
            log.info("你好啊,凡人.");
        }

        //测试一个权限 (非（instance-level）实例级别)
        if (currentUser.isPermitted("school:meeting-room")) {
            log.info("你正在使用会议室,请随意");
        } else {
            log.info("对不起,你没有权限使用会议室");
        }

        //一个(非常强大)的实例级别的权限:
        if (currentUser.isPermitted("book:read:math5")) {
            log.info("你已经有权'阅读read'-'数学第五册math5'-这本'书'了,请自便");
        } else {
            log.info("对不起,你对'math5'这本'书'没有'阅读'权限");
        }

        //完成 - 退出t!
        currentUser.logout();

        System.exit(0);
    }
}