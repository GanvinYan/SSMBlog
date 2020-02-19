package com.gavin.initalizestart.controller;

import com.gavin.initalizestart.domain.Authority;
import com.gavin.initalizestart.domain.User;
import com.gavin.initalizestart.service.AuthorityService;
import com.gavin.initalizestart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：主页控制器
 * 创建时间: 2018年9月5日 下午10:42:53
 *
 * @author gang.yan
 */
@Controller
public class MainController {

    private static final long ROLE_USER_AUTHORITY_ID = 2L;

    @Autowired
    UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @GetMapping("/")
    private String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "forward:/blogs";
    }

    /**
     * 获取登录界面
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * @return java.lang.String
     * @Description //注册用户
     * @Param [user]
     * @Author gang.yan
     * @Date 12:32 2019/11/10
     */
    @PostMapping("/register")
    public String registerUser(User user) {
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
        user.setAuthorities(authorities);
        userService.saveUser(user);
        return "redirect:/login";
    }

}
