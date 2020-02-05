package com.gavin.initalizestart.repository;

import com.gavin.initalizestart.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Comment Repository 接口
 * @author gang
 * @since 2020.02.02
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
