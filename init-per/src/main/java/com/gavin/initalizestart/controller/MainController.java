package com.gavin.initalizestart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述：主页控制器
 * 创建时间: 2018年9月5日 下午10:42:53 
 *
 * @author gang.yan
 */
@Controller
public class MainController {
	
	@GetMapping("/")
	private String root() {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError",true);
		model.addAttribute("errorMsg","登陆失败，用户名或密码错误！");
		return "login";
	}
}
