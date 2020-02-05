package com.gavin.initalizestart.service;

import com.gavin.initalizestart.domain.Comment;

public interface CommentService {

    /**
     * 根据id获取 Comment
     * @param id
     * @return
     */
    Comment getCommetById(Long id);

    /**
     * 删除评论
     *
     * @param id
     */
    void removeComment(Long id);
}
