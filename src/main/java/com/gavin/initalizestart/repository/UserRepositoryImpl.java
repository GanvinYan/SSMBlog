package com.gavin.initalizestart.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.gavin.initalizestart.domain.User;

/**
 * 描述：
 * 创建时间: 2018年7月5日 下午3:37:35 
 *
 * @author gang.yan
 */
@Repository
public class UserRepositoryImpl implements UserRepository{

	private static AtomicLong counter = new AtomicLong();//用来做计数 会有唯一的Id
	private final ConcurrentMap<String,User> userMap = new ConcurrentHashMap<>();
	@Override
	public User saveOrUpdateUser(User user) {
		String id =user.getId();
		if (id== null) {//新建
			id = String.valueOf(counter.incrementAndGet()); 
			user.setId(id);
		} 
		this.userMap.put(id, user);
		return user;
	}

	@Override
	public void deleteUser(String id) {
		this.userMap.remove(id);
	}

	@Override
	public User getUserById(String id) {
		
		return this.userMap.get(id);
	}

	@Override
	public List<User> lisetUser() {
		
		return new ArrayList<User>(this.userMap.values());
	}

}