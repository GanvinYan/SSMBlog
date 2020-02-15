package com.gavin.initalizestart.service;

import com.gavin.initalizestart.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface UserService {

    /**
     * 保存用户
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     *
     * @param user
     * @return
     */
    User regisreUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    void removeUser(Long id);

    /**
     * 根据Id获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 根据用户明进行分页模糊查询
     * @param name
     * @param pageable
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);

    /**
     * 根据用户名集合查询用户详细信息
     * @param usernames
     * @return
     */
    List<User> listUsersByUsernames(Collection<String> usernames);
}
