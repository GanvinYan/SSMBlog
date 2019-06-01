package com.gavin.initalizestart.repository;

import com.gavin.initalizestart.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述：User Repository 接口
 * 创建时间: 2018年7月5日 下午3:25:37 
 *
 * @author gang.yan
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByNameLike(String name, Pageable pageable);

    User findByUsername(String username);

}
