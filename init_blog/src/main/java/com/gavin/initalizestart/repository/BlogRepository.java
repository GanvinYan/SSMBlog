package com.gavin.initalizestart.repository;

import com.gavin.initalizestart.domain.Blog;
import com.gavin.initalizestart.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Blog 仓库
 * @author gang.yan
 */
public interface BlogRepository extends JpaRepository<Blog,Long> {

    /**
     * 根据用户名、博客标题分页查询博客列表
     * @param user
     * @param title
     * @param pageable
     * @return
     */
    Page<Blog> findByUserAndTitleLike(User user, String title , Pageable pageable);

    /**
     * 根据用户名、博客查询博客列表（时间逆序）
     * @param title
     * @param user
     * @param tags
     * @param pageable
     * @return
     */
    Page<Blog> findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(String title,User user,String tags, Pageable pageable);


}
