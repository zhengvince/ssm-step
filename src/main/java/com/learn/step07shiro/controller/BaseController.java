package com.learn.step07shiro.controller;


import com.learn.step06ehcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/*
 * Controller基类
 */
@Controller
public class BaseController {
	@Autowired
	private UserService userService;

	public UserService getUserService() {

		return userService;
	}
}
