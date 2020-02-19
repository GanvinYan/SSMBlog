package com.gavin.initalizestart.controller;

import com.gavin.initalizestart.domain.Blog;
import com.gavin.initalizestart.domain.Comment;
import com.gavin.initalizestart.domain.User;
import com.gavin.initalizestart.service.BlogService;
import com.gavin.initalizestart.service.CommentService;
import com.gavin.initalizestart.util.ConstraintViolationExceptionHandler;
import com.gavin.initalizestart.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * 评论控制层
 *
 * @author gang
 * @since 2020.02.02
 */

@Controller
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    /**
     * 获取评论列表
     *
     * @param blogId
     * @param model
     * @return
     */
    @GetMapping
    public String listComment(@RequestParam(value = "blogId", required = true) Long blogId, Model model) {
        Blog blog = blogService.getBlogById(blogId);
        List<Comment> comments = blog.getComments();

        //判断操作用户是否是评论的所有者
        String commentOwner = "";

        if (SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
                && !SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equals("anonymousUser")) {
            User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal != null) {
                commentOwner = principal.getUsername();
            }
        }

        model.addAttribute("commentOwner", commentOwner);
        model.addAttribute("comments", comments);
        return "/userspace/blog :: #mainContainerRepleace";
    }

    /**
     * 发表评论
     * @param blogId
     * @param commentContent
     * @return
     */
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<Response> creatComment(Long blogId, String commentContent) {
        try {
            blogService.creatCommet(blogId, commentContent);
        } catch (ConstraintViolationException e) {
            return ResponseEntity.ok().body(new Response(false, ConstraintViolationExceptionHandler.getMessage(e)));
        } catch (Exception e){
            return ResponseEntity.ok().body(new Response(false, e.getMessage()));
        }
        return ResponseEntity.ok().body(new Response(true, "处理成功", null));
    }

    /**
     * 删除评论
     * @param id
     * @param blogId
     * @return
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<Response> delete(@PathVariable("id")Long id,Long blogId){

        boolean isOwner =false;
        User user = commentService.getCommetById(id).getUser();

        // 判断操作用户是否是博客的所有者
        if (SecurityContextHolder.getContext().getAuthentication() !=null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
                &&  !SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equals("anonymousUser")) {
            User principal = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal !=null && user.getUsername().equals(principal.getUsername())) {
                isOwner = true;
            }
        }

        if (!isOwner) {
            return ResponseEntity.ok().body(new Response(false, "没有操作权限"));
        }

        try {
            blogService.removeComment(blogId, id);
            commentService.removeComment(id);
        } catch (ConstraintViolationException e)  {
            return ResponseEntity.ok().body(new Response(false, ConstraintViolationExceptionHandler.getMessage(e)));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new Response(false, e.getMessage()));
        }

        return ResponseEntity.ok().body(new Response(true, "处理成功", null));


    }


}
