package com.learn.step07shiro.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "learn/shiro")
public class UserController {

	private final String SHIRO = "learn/shiro/";

	@RequestMapping(value = "/admin-center")
	public String adminCenter() {
		return SHIRO+"admin/adminCenter";

	}
	@RequestMapping(value = "/user-center")
	public String userCenter() {
		return SHIRO+"user/userCenter";

	}



}
