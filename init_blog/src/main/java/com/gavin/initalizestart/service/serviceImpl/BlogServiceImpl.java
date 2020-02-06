package com.gavin.initalizestart.service.serviceImpl;

import com.gavin.initalizestart.domain.*;
import com.gavin.initalizestart.repository.BlogRepository;
import com.gavin.initalizestart.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Blog 服务.
 * @author gang
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void removeBlog(Long id) {
        blogRepository.delete(id);
    }

    @Override
    public Blog updateBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public Page<Blog> listBlogsByTitleLike(User user, String title, Pageable pageable) {
        // 模糊查询
        title = "%" + title + "%";
        String tags = title;
        Page<Blog> blogs = blogRepository.findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(title, user,tags,user, pageable);
        return blogs;
    }


    @Override
    public Page<Blog> listBlogsByTitleLikeAndSort(User user, String title, Pageable pageable) {
        // 模糊查询
        title = "%" + title + "%";
        Page<Blog> blogs = blogRepository.findByUserAndTitleLike(user,title,pageable);
        return blogs;
    }

    @Override
    public void readingIncrease(Long id) {
        Blog blog = blogRepository.findOne(id);
        blog.setReadSize(blog.getReadSize() + 1);
        this.saveBlog(blog);
    }

    @Override
    public Blog creatCommet(Long blogId, String commentCont) {
        Blog originalBlog = blogRepository.findOne(blogId);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Comment comment = new Comment(user, commentCont);
        originalBlog.addComment(comment);
        return this.saveBlog(originalBlog);
    }

    @Override
    public void removeComment(Long blogId, Long commetId) {
        Blog originalBlog = blogRepository.findOne(blogId);
        originalBlog.removeComment(commetId);
        this.saveBlog(originalBlog);
    }

    @Override
    public Blog createVote(Long blogID) {
        Blog originalBlog = blogRepository.findOne(blogID);
        User user =(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Vote vote = new Vote(user);
        boolean isExist = originalBlog.addVote(vote);
        if(isExist){
            throw new IllegalArgumentException("该用户已经点过赞了");
        }
        return this.saveBlog(originalBlog);
    }

    @Override
    public void removeVote(Long blogId, Long voteId) {
        Blog originalBlog = blogRepository.findOne(blogId);
        originalBlog.removeVote(voteId);
        this.saveBlog(originalBlog);
    }

    @Override
    public Page<Blog> listBlogsByCatalog(Catalog catalog, Pageable pageable) {

        Page<Blog> blogs = blogRepository.findByCatalog(catalog, pageable);
        return blogs;
    }
}
