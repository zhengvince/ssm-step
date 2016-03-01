package com.learn.step04log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;


/**
 * 用于测试日志的类
 * Created by Vince on 2016/3/1.
 */
@Controller
@RequestMapping("/learn/log")
public class HelloLog4jController {

    public static Logger log = LoggerFactory.getLogger(HelloLog4jController.class);
    Integer id =123455555;
    String symbol="占位符";

    @RequestMapping( method = RequestMethod.GET)
    public String logIndex(){
        log.trace("trace信息");
        log.debug("debug信息");
        log.info("info信息");
        log.warn("warn信息");
        log.error("error信息");
        log.debug("Processing trade with id: {} and symbol : {} ", id, symbol);
        log.info("三个参数:agrs1:{};agrs2:{} 的info级别日志", "占位符1", "参数2",
                new IOException("测试抛出IO异常信息"));
        return "learn/index";
    }
    @RequestMapping( value = "debug",method = RequestMethod.GET)
    public String logDebug(){
        log.debug("测试日志输出～～～～～～～～～～～～～～～～～: {} and symbol : {} ", id, symbol);
        return "learn/index";
    }

    @RequestMapping( value = "error",method = RequestMethod.GET)
    public String logError(){
        log.error("测试error～～～～～～～～～～～～～～～～");
        return "learn/index";
    }

}
