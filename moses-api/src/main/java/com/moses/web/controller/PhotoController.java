/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.controller;

import com.moses.framework.common.base.BaseController;
import com.moses.web.model.Photo;
import com.moses.web.service.PhotoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Moses
 * @date 2020/6/20
 */
@Api("Photo API")
@Controller
@RequestMapping(value = "/photo")
public class PhotoController extends BaseController {
    static String PREFIX = "photo/";
    static String HEADER = "照片管理";
    static String REDIRECT = "redirect:/photo/list";
    @Resource
    PhotoService photoService;

    @GetMapping("/")
    public String index() {
        return REDIRECT;
    }

    @GetMapping("/toAdd")
    @ApiOperation(value = "Photo add", notes = "Photo add")
    public String add(Model model) {
        model.addAttribute("header", HEADER);
        return PREFIX + "photoAdd";
    }

    @PostMapping("/add")
    @ApiOperation(value = "add Photo", notes = "add Photo")
    public String add(Photo photo) {
        photoService.save(photo);
        return REDIRECT;
    }

    @GetMapping("/toEdit")
    @ApiOperation(value = "Photo edit", notes = "Photo edit")
    public String toEdit(Model model, long id) {
        Photo photo = photoService.getOne(id);
        model.addAttribute("photo", photo);
        model.addAttribute("header", HEADER);
        return PREFIX + "photoEdit";
    }

    @PostMapping("/edit")
    @ApiOperation(value = "edit Photo", notes = "edit Photo")
    public String edit(Photo photo) {
        photoService.edit(photo);
        return REDIRECT;
    }

    @GetMapping("/toDetail")
    @ApiOperation(value = "Photo Detail", notes = "Photo Detail")
    public String toDetail(Model model, long id) {
        Photo photo = photoService.getOne(id);
        model.addAttribute("photo", photo);
        model.addAttribute("header", HEADER);
        return PREFIX + "photoDetail";
    }

    @GetMapping("/delete")
    @ApiOperation(value = "delete Photo", notes = "delete Photo")
    public String delete(long id) {
        photoService.delete(id);
        return REDIRECT;
    }
}
