package com.gavin.initalizestart.service;

import com.gavin.initalizestart.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
     *
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

}
