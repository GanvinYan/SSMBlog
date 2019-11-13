package com.gavin.initalizestart.service.serviceImpl;

import com.gavin.initalizestart.domain.Authority;
import com.gavin.initalizestart.repository.AuthorityRepository;
import com.gavin.initalizestart.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: gang.yan
 * @Date: 2019/11/10 11:52
 * @Version: 1.0
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityRepository.findOne(id);
    }
}
