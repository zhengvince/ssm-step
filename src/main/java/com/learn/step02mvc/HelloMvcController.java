package com.learn.step02mvc;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ToDo...
 * Created by Vince on 2016/3/1.
 */
@Controller
@RequestMapping("/")
public class HelloMvcController {

    @RequestMapping(method = RequestMethod.GET)
    public String helloIndex(){
        return "learn/index";
    }

    @ResponseBody
    @RequestMapping(value = "learn/json")
    public String helloJson(){
        return "json";
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
    @RequestMapping(value = "learn/cn" , produces="application/json;charset=utf-8")
    public String helloCn(){
        return "使用@ResponseBody时，产生乱码的解决";

    }

}
