package com.gavin.initalizestart.repository;

import com.gavin.initalizestart.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * 描述：User Repository 接口
 * 创建时间: 2018年7月5日 下午3:25:37 
 *
 * @author gang.yan
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据名称模糊查询
     * @param name
     * @param pageable
     * @return
     */
    Page<User> findByNameLike(String name, Pageable pageable);

    /**
     * 根据用户名称查询呢用户列表
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据名称列表查询用户名列表
     * @return
     */
    List<User> findByUsernameIn(Collection<String> username);
}
