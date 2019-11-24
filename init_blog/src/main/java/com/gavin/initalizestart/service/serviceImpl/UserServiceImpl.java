package com.gavin.initalizestart.service.serviceImpl;

import com.gavin.initalizestart.domain.User;
import com.gavin.initalizestart.repository.UserRepository;
import com.gavin.initalizestart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 用户接口服务
 *
 */
@Service
public class UserServiceImpl implements UserService,UserDetailsService
{

    @Autowired
    private UserRepository userRepository;

    /**
     * @Description 保存增加事务注解
     * @Param [user]
     * @return com.gavin.initalizestart.domain.User
     * @Author gang.yan
     * @Date 20:14 2019/11/13
     */
    @Override
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User regisreUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> listUsersByNameLike(String name, Pageable pageable) {
        // 模糊查询
        name = "%" + name + "%";
        Page<User> users = userRepository.findByNameLike(name, pageable);
        return users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return  userRepository.findByUsername(username);
    }
}
