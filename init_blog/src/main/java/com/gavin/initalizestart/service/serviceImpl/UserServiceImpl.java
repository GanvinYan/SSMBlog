package com.gavin.initalizestart.service.serviceImpl;

import com.gavin.initalizestart.domain.User;
import com.gavin.initalizestart.repository.UserRepository;
import com.gavin.initalizestart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 用户接口服务
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User saveuser(User user) {
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
        return null;
    }

    @Override
    public Page<User> listUsersByNameLike(String name, Pageable pageable) {
        return null;
    }
}
