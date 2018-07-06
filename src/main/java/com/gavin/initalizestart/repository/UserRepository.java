package com.gavin.initalizestart.repository;

import java.util.List;

import com.gavin.initalizestart.domain.User;

/**
 * 描述：User Repository 接口
 * 创建时间: 2018年7月5日 下午3:25:37 
 *
 * @author gang.yan
 */

public interface UserRepository {
	
	/**
	 * 
	 * 创建时间: 2018年7月5日 下午3:31:12 
	 * @param user
	 * @return
	 * @author gang.yan
	 */
	User saveOrUpdateUser(User user);
	
	/**
	 *删除用户 
	 * 创建时间: 2018年7月5日 下午3:32:33 
	 * @param id
	 * @author gang.yan
	 */
	void deleteUser(String id);
	
	/**
	 *根据id查询用户 
	 * 创建时间: 2018年7月5日 下午3:33:48 
	 * @param id
	 * @return
	 * @author gang.yan
	 */
	User getUserById(String id);
	
	/**
	 *获取用户列表 
	 * 创建时间: 2018年7月5日 下午3:35:26 
	 * @return
	 * @author gang.yan
	 */
	List<User> lisetUser();

}
