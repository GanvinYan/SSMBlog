package com.gavin.initalizestart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述：Blog控制器
 * 创建时间: 2018年10月28日 下午9:34:59 
 *
 * @author gang.yan
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {
	
	/**
	 * 
	 * 创建时间: 2018年10月28日 下午9:45:07 
	 * @param order 默认参数
	 * @return
	 * @author gang.yan
	 */
	@GetMapping
	public String lisBlogs(@RequestParam(value="order",required=false,defaultValue="new") String order,
			@RequestParam(value="tag",required=false) Long keyword) {
		System.out.print("order:"+order+";keyword:"+keyword);
		return "redirect:/index?order="+order+"&tag="+keyword;
	}
}
