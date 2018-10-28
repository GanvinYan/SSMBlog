package com.gavin.initalizestart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述：后台管理控制器
 * 创建时间: 2018年10月28日 下午10:36:30 
 * @author gang.yan
 */
@Controller
@RequestMapping("/admins")
public class AdminController {

	/**
	 * 
	 * 创建时间: 2018年10月28日 下午10:41:32 
	 *
	 * @param model
	 * @return
	 * @author gang.yan
	 */
	@RequestMapping
	public ModelAndView listUsers(Model model) {
		return new ModelAndView("admins/index","menulist",model);
	} 
}
