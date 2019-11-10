package com.gavin.initalizestart.controller;


import com.gavin.initalizestart.service.UserService;
import com.gavin.initalizestart.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.gavin.initalizestart.domain.User;
import com.gavin.initalizestart.repository.UserRepository;

import java.util.List;

/**
 * 描述：User 控制器
 * 创建时间: 2018年7月5日 下午5:35:11
 *
 * @author gang.yan
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 查询所有用户
     * 创建时间: 2018年7月5日 下午8:51:01
     *
     * @param model
     * @return
     * @author gang.yan
     */
    @GetMapping
    public ModelAndView list(@RequestParam(value = "async", required = false) boolean async,
                             @RequestParam(value = "pageIndex", required = false, defaultValue = "0") int pageIndex,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                             @RequestParam(value = "name", required = false, defaultValue = "") String name, Model model) {

        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<User> page = userService.listUsersByNameLike(name, pageable);
        List<User> list = page.getContent();    // 当前所在页面数据列表

        log.info("-----");

        model.addAttribute("page", page);
        model.addAttribute("userList", list);

        return new ModelAndView(async == true ? "users/list :: #mainContainerRepleace" : "users/list", "userModel", model);
    }


    /**
     * 获取表单用户
     * 创建时间: 2018年7月5日 下午9:06:21
     *
     * @param model
     * @return
     * @author gang.yan
     */
    @GetMapping("/add")
    public ModelAndView creatForm(Model model) {
        model.addAttribute("user", new User(null, null, null, null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/add", "userModel", model);
    }


    @PostMapping
    public ResponseEntity<Response> create(User user, long author) {

        return null;
    }

    /**
     * 删除
     * 创建时间: 2018年7月25日 下午10:12:01
     *
     * @param id
     * @return
     * @author gang.yan
     */
    @GetMapping("/delete/{id}")
    public ResponseEntity delte(@PathVariable("id") Long id, Model model) {
        try {
            userService.removeUser(id);
        } catch (Exception e) {
            return  ResponseEntity.ok().body( new Response(false, e.getMessage()));
        }
        return  ResponseEntity.ok().body( new Response(true, "处理成功"));
    }


    /**
     * 获取修改用户的界面，及数据
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "edit/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return new ModelAndView("users/edit", "userModel", model);
    }
}
