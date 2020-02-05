package com.gavin.initalizestart.service;

import com.gavin.initalizestart.domain.Blog;
import com.gavin.initalizestart.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    /**
     * 保存Blog
     * @param blog
     * @return
     */
    Blog saveBlog(Blog blog);

    /**
     * 删除Blog
     * @param id
     * @return
     */
    void removeBlog(Long id);

    /**
     * 更新Blog
     * @param blog
     * @return
     */
    Blog updateBlog(Blog blog);

    /**
     * 根据id获取Blog
     * @param id
     * @return
     */
    Blog getBlogById(Long id);

    /**
     * 根据用户名进行分页模糊查询（最新）
     * @param user
     * @return
     */
    Page<Blog> listBlogsByTitleLike(User user, String title, Pageable pageable);

    /**
     * 根据用户名进行分页模糊查询（最热）
     * @param user
     * @return
     */
    Page<Blog> listBlogsByTitleLikeAndSort(User user, String title, Pageable pageable);

    /**
     * 阅读量递增
     * @param id
     */
    void readingIncrease(Long id);

    /**
     * 发表评论
     * @param blogId
     * @param commentCont
     * @return
     */
    Blog creatCommet(Long blogId,String commentCont);

    /**
     * 删除评论
     * @param blogId
     * @param commetId
     */
    void removeComment(Long blogId, Long commetId);
}
