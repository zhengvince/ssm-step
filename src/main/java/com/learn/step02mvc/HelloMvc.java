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
public class HelloMvc {

    @RequestMapping(method = RequestMethod.GET)
    public String helloIndex(){
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "json")
    public String helloJson(){
        return "json";
    }


}
