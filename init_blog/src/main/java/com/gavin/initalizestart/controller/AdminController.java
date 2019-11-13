package com.gavin.initalizestart.controller;

import com.gavin.initalizestart.vo.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：后台管理控制器
 * 创建时间: 2018年10月28日 下午10:36:30 
 * @author gang.yan
 */
@Controller
@RequestMapping("/admins")
public class AdminController {

    /**
     *
     * 创建时间: 2018年10月28日 下午10:41:32
     *
     * @param model
     * @return
     * @author gang.yan
     */
    @RequestMapping
    public ModelAndView listUsers(Model model) {
        List<Menu> list = new ArrayList<>();
        list.add(new Menu("用户管理", "/users"));
        list.add(new Menu("角色管理", "/roles"));
        list.add(new Menu("博客管理", "/blogs"));
        list.add(new Menu("评论管理", "/commits"));
        model.addAttribute("list", list);
        return new ModelAndView("admins/index","menulist",model);
    }
}
