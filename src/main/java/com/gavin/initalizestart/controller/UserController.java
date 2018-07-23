package com.gavin.initalizestart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gavin.initalizestart.domain.User;
import com.gavin.initalizestart.repository.UserRepository;

/**
 * 描述：User 控制器
 * 创建时间: 2018年7月5日 下午5:35:11 
 * @author gang.yan
 */
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	/**
	 *查询所有用户 
	 * 创建时间: 2018年7月5日 下午8:51:01 
	 *
	 * @param model
	 * @return
	 * @author gang.yan
	 */
	@GetMapping
	public ModelAndView list(Model model) {
		model.addAttribute("userList",userRepository.lisetUser());
		model.addAttribute("title","用户管理");
		return new ModelAndView("users/list","userModel",model);
	}
	/**
	 *根据 id 查询用户 
	 * 创建时间: 2018年7月5日 下午9:02:34 
	 * @param id
	 * @param model
	 * @return
	 * @author gang.yan
	 */
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id,Model model) {
		User user = userRepository.getUserById(id);
		model.addAttribute("user",user);
		model.addAttribute("title","查看用户");
		return new ModelAndView("users/view","userModel",model);
	}
	/**
	 * 获取表单用户
	 * 创建时间: 2018年7月5日 下午9:06:21 
	 * @param model
	 * @return
	 * @author gang.yan
	 */
	@GetMapping("/form")
	public ModelAndView creatForm(Model model) {
		model.addAttribute("user",new User());
		model.addAttribute("title","创建用户");
		return new ModelAndView("users/form","userModel",model);
	}
	
	/**
	 * 保存或修改用户
	 * 创建时间: 2018年7月6日 下午3:59:32 
	 * @param user
	 * @return
	 * @author gang.yan
	 */
	@PostMapping
	public ModelAndView saveorupdateUser(User user) {
		user = userRepository.saveOrUpdateUser(user);
		return new ModelAndView("redirect:/users");//重定向到list页面
	}
}
