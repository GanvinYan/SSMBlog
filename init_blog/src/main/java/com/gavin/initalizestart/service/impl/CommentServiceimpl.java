package com.gavin.initalizestart.service.impl;

import com.gavin.initalizestart.domain.Comment;
import com.gavin.initalizestart.repository.CommentRepository;
import com.gavin.initalizestart.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * comment 服务
 */
@Service
public class CommentServiceimpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment getCommetById(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public void removeComment(Long id) {
        commentRepository.delete(id);
    }
}
