package com.gavin.initalizestart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 * 创建时间: 2018年8月30日 下午10:58:32 
 *
 * @author gang.yan
 */

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
	    return "Hello World!";
	}
}
