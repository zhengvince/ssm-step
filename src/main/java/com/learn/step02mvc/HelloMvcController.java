package com.learn.step02mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * 用于测试mvc的类
 * Created by Vince on 2016/3/1.
 */
@Controller
@RequestMapping("learn/mvc")
public class HelloMvcController {

    //根目录
    @RequestMapping(method = RequestMethod.GET)
    public String helloIndex(){
        return "learn/learn";
    }

    //json
    @ResponseBody
    @RequestMapping(value = "/json")
    public String helloJson(){
        return "json";
    }

    /**
     * 控制器中添加 Map 类型的传入参数.
     */
    @RequestMapping( "/learnMap")
    public String testMap(Map<String, Object> map){
        map.put( "names", Arrays.asList("Tom", "Jerry", "Mike"));
        map.put( "car", "奥迪");
        return "learn/mvc/learnMap";
    }

    /*
    |
    |--------------------------------------------------------------------------
    | 解决@ResponseBody乱码问题
    |--------------------------------------------------------------------------
    |
    | 方案一：   如下添加 produces="application/json;charset=utf-8"
    |           spring-mvc.xml里添加<mvc:annotation-driven/>
    | 其他方案见http://josh-persistence.iteye.com/blog/2085015
    |
    */
    @ResponseBody
    @RequestMapping(value = "/cn" , produces="application/json;charset=utf-8")
    public String helloCn(){
        return "使用@ResponseBody时，产生乱码的解决";

    }

}
