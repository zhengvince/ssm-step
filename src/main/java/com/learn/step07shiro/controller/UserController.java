package com.learn.step07shiro.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "user")
public class UserController extends BaseController {

	@RequestMapping(value = "/LoginPage")
	public String loginPage() {
		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date());
		System.out.println(now + "to LoginPage!!!");
		return "login";
	}

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, String username,
			String password) {
		System.out.println("username:" + username + "----" + "password:"
				+ password);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		String error = null;
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			error = "没有这个账号";
		} catch (IncorrectCredentialsException e) {
			error = "用户名/密码错误";
		} catch (ExcessiveAttemptsException e) {
			error = "登录失败多次，账户锁定10分钟";
		} catch (AuthenticationException e) {
			// 其他错误，比如锁定，如果想单独处理请单独catch处理
			error = "其他错误：" + e.getMessage();
		}
		if (error != null) {// 出错了，返回登录页面
			request.setAttribute("error", error);
			return "failure";
		} else {// 登录成功
			return "success";
		}

	}


}
