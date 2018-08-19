package com.gavin.initalizestart.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gavin.initalizestart.domain.User;

/**
 * 描述：User Repository 接口
 * 创建时间: 2018年7月5日 下午3:25:37 
 *
 * @author gang.yan
 */

public interface UserRepository extends  CrudRepository<User, Long>{

}
