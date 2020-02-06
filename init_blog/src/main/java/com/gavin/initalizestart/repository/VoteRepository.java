package com.gavin.initalizestart.repository;

import com.gavin.initalizestart.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * vote Repository 接口
 * @since 2020.02.05
 * @author gang
 */
public interface VoteRepository extends JpaRepository<Vote, Long> {


}
