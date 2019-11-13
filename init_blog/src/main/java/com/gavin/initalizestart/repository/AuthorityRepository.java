package com.gavin.initalizestart.repository;

import com.gavin.initalizestart.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: Authority 仓库
 * @Author: gang.yan
 * @Date: 2019/11/10 11:45
 * @Version: 1.0
 */
public interface AuthorityRepository extends JpaRepository<Authority,Long> {
}
