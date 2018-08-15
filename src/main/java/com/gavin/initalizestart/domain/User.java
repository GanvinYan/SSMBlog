package com.gavin.initalizestart.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * 描述：User 实体
 * 创建时间: 2018年7月5日 下午2:22:21 
 *
 * @author gang.yan
 */
@Entity
public class User {
	
	@Id  // 主键
    @GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private Long id;
	private String name;
	private String email;
	
	public User() { //无参构造函数
		
	}
	public User(Long id,String name,String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
