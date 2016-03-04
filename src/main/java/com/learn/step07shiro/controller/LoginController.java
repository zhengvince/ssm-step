package com.learn.step07shiro.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/learn")
public class LoginController {


	@RequestMapping( method = RequestMethod.GET)
	public String login() {
		return "learn/learn";

	}

	@RequestMapping(value = "/login")
	public String adminCenter() {
		return "learn/login";

	}
	@RequestMapping(value = "/no-permission")
	public String noPermission() {
		return "learn/error/noPermission";

	}
    @RequestMapping(value = "/error")
    public String errorMsg() {
        return "learn/error/msg";

    }


}
