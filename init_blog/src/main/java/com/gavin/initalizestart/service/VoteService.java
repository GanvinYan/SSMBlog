package com.gavin.initalizestart.service;

import com.gavin.initalizestart.domain.Vote;

/**
 * Vote 服务接口
 */
public interface VoteService {

    /**
     * 根据id获取Vote
     * @param id
     * @return
     */
    Vote getVoteById(Long id);

    /**
     * 取消点赞
     * @param id
     */
    void removeVote(Long id);
}
