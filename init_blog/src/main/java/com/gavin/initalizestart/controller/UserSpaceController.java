package com.gavin.initalizestart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述：用户主页控制器
 * 创建时间: 2018年10月28日 
 *
 * @author gang.yan
 */
@Controller
@RequestMapping("/u")
public class UserSpaceController {
	
	/**
	 * 
	 * 创建时间: 2018年10月28日 
	 * @param order 默认参数
	 * @param tag 标签
	 * @return
	 */
	@GetMapping("/{username}")
	public String userSpace(@PathVariable("username") String username) {
		System.out.println("username"+username);
		return "/userspace/u";
	}
	@GetMapping("/{username}/blogs")
	public String listBlogsByOrder(@PathVariable("username") String username,
			@RequestParam(value="order",required=false,defaultValue="new") String order,
			@RequestParam(value="category",required=false ) Long category,
			@RequestParam(value="keyword",required=false ) String keyword) {
		if (category != null) {
			System.out.println("keyword:"+keyword);
			System.out.println("selflink:"+"redirect:/u/"+username+"/blogs?category="+category);
			return "/userspace/u";
		}else if ( keyword != null && keyword.isEmpty() == false) {
			System.out.println("keyword:"+keyword);
			System.out.println("selflink:"+"redirect:/u/"+username+"/blogs?keyword="+keyword);
			return "/userspace/u";
		}
		
		System.out.println("order:"+order);
		return "/userspace/u";
	}
	
	@GetMapping("/user")
	public String listBlogsByorder(@PathVariable("id") long id) {
		
		System.out.print("blog:"+id);
		return "/userspace/blog";
	}
	
	@GetMapping("/{username}/blogs/edit")
	public String editBlog() {
		
		return "/userspace/blogedit";
	}
}
