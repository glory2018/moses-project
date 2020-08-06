/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.controller;

import com.moses.framework.common.base.BaseController;
import com.moses.web.model.User;
import com.moses.web.service.UserService;
import com.moses.web.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author Moses
 * @date 2020/6/20
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

    @GetMapping("/")
    public String index() {
        return REDIRECT;
    }

    @GetMapping("/list")
    @ApiOperation(value = "list User", notes = "list User")
    public String list(Model model) {
        Page<User> users = userService.getPageList();
        model.addAttribute("page", users);
        model.addAttribute("header", HEADER);
        return PREFIX + "userList";
    }

    @PostMapping("/list")
    @ApiOperation(value = "list User", notes = "list User")
    public String list(Model model, UserVo vo) {
        Page<User> users = userService.getPageList(vo);
        model.addAttribute("page", users);
        return PREFIX + "userList::table_list";
    }

    @GetMapping("/toAdd")
    @ApiOperation(value = "User add", notes = "User add")
    public String add(Model model) {
        model.addAttribute("header", HEADER);
        return PREFIX + "userAdd";
    }

    @PostMapping("/add")
    @ApiOperation(value = "add User", notes = "add User")
    public String add(@Valid User user) {
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

    @PostMapping("/edit")
    @ApiOperation(value = "edit User", notes = "edit User")
    public String edit(@Valid User user) {
        userService.edit(user);
        return REDIRECT;
    }

    @GetMapping("/toDetail")
    @ApiOperation(value = "User Detail", notes = "User Detail")
    public String toDetail(Model model, long id) {
        User user = userService.getOne(id);
        model.addAttribute("user", user);
        model.addAttribute("header", HEADER);
        return PREFIX + "userDetail";
    }

    @GetMapping("/delete")
    @ApiOperation(value = "delete User", notes = "delete User")
    public String delete(long id) {
        userService.delete(id);
        return REDIRECT;
    }

    @GetMapping("/toImport")
    @ApiOperation(value = "User import", notes = "User import")
    public String toImport(Model model) {
        model.addAttribute("header", HEADER);
        return PREFIX + "userImport";
    }

    @PostMapping("/importUser")
    @ApiOperation(value = "add User", notes = "add User")
    public String importUser(MultipartFile file) {
        userService.importUser(file);
        return REDIRECT;
    }
}
