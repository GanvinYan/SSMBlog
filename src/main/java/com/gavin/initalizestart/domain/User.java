package com.gavin.initalizestart.domain;

/**
 * 描述：User 实体
 * 创建时间: 2018年7月5日 下午2:22:21 
 *
 * @author gang.yan
 */

public class User {
	private String id;
	private String name;
	private String email;
	
	public User() { //无参构造函数
		
	}
	public User(String id,String name,String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
