package com.learn.step04log4j;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * 测试日志类
 * Created by Vince on 2016/3/1.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class HelloLog4jControllerTest extends TestCase {


    public static Logger log = LoggerFactory.getLogger(HelloLog4jController.class);

    @Test
    public void testLogIndex() {
        Integer id =123455555;
        String symbol="占位符";
        log.trace("trace信息");
        log.debug("debug信息");
        log.info("info信息");
        log.warn("warn信息");
        log.error("error信息");
        log.debug("Processing trade with id: {} and symbol : {} ", id, symbol);
        log.info("三个参数:agrs1:{};agrs2:{} 的info级别日志", "占位符1", "参数2",
                new IOException("测试抛出IO异常信息"));
    }
}