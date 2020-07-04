/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.web;

import com.moses.demo.model.User;
import com.moses.demo.service.UserService;
import com.moses.framework.common.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Moses
 * @date 2020/5/20
 */
@Api("User API")
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
    static String PREFIX = "user/";
    static String HEADER = "用户管理";
    static String REDIRECT = "redirect:/user/list";
    @Resource
    UserService userService;

    @RequestMapping("/")
    public String index() {
        return REDIRECT;
    }

    @GetMapping("/list")
    @ApiOperation(value = "list User", notes = "list User")
    public String list(Model model) {
        List<User> users = userService.getList();
        model.addAttribute("users", users);
        model.addAttribute("header", HEADER);
        return PREFIX + "userList";
    }

    @GetMapping("/toAdd")
    @ApiOperation(value = "User add", notes = "User add")
    public String add(Model model) {
        model.addAttribute("header", HEADER);
        return PREFIX + "userAdd";
    }

    @PostMapping("/add")
    @ApiOperation(value = "add User", notes = "add User")
    public String add(User user) {
        userService.save(user);
        return REDIRECT;
    }

    @GetMapping("/toEdit")
    @ApiOperation(value = "User edit", notes = "User edit")
    public String toEdit(Model model, long id) {
        User user = userService.getOne(id);
        model.addAttribute("user", user);
        model.addAttribute("header", HEADER);
        return PREFIX + "userEdit";
    }

    @GetMapping("/toDetail")
    @ApiOperation(value = "User Detail", notes = "User Detail")
    public String toDetail(Model model, long id) {
        User user = userService.getOne(id);
        model.addAttribute("user", user);
        model.addAttribute("header", HEADER);
        return PREFIX + "userDetail";
    }

    @PostMapping("/edit")
    @ApiOperation(value = "edit User", notes = "edit User")
    public String edit(User user) {
        userService.edit(user);
        return REDIRECT;
    }

    @GetMapping("/delete")
    @ApiOperation(value = "delete User", notes = "delete User")
    public String delete(long id) {
        userService.delete(id);
        return REDIRECT;
    }
}
