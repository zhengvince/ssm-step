package com.learn.step03rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用于测试REST风格的url映射的类
 * Created by Vince on 2016/2/18.
 */
@Controller
@RequestMapping("/learn/rest")
public class HelloRestController {

    /*
    |
    |--------------------------------------------------------------------------
    | REST风格的url映射
    |--------------------------------------------------------------------------
    |
    |  获取: /rest/1     GET
    |  新增: /rest       POST
    |  修改: /rest/1     PUT
    |  删除: /rest/1     DELETE
    |
    */
    public String restReturnView = "learn/rest/rest";
    /**
     * GET
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String restGet( @PathVariable Integer id) {
        System.out.println( "查看Get: " + id);
        return restReturnView;
    }
    /**
     * POST
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String restPost() {
        System.out.println( "新增Post: ");
        return restReturnView;
    }
    /**
     * PUT
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String restPut( @PathVariable Integer id) {
        System.out.println( "修改Put: " + id);
        return restReturnView;
    }
    /**
     * DELETE
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String restDelete( @PathVariable Integer id) {
        System.out.println( "删除Delete: " + id);
        return restReturnView;
    }


}
