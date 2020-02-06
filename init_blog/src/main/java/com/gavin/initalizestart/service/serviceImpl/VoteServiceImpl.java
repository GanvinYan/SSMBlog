package com.gavin.initalizestart.service.serviceImpl;

import com.gavin.initalizestart.domain.Vote;
import com.gavin.initalizestart.repository.VoteRepository;
import com.gavin.initalizestart.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public Vote getVoteById(Long id) {
        return voteRepository.findOne(id);
    }

    @Override
    public void removeVote(Long id) {
        voteRepository.delete(id);
    }
}
