/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.controller;

import com.moses.framework.common.base.BaseController;
import com.moses.web.model.Laboratory;
import com.moses.web.service.LaboratoryService;
import com.moses.web.vo.LaboratoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author Moses
 * @date 2020/6/20
 */
@Api("Laboratory API")
@Controller
@RequestMapping(value = "/laboratory")
public class LaboratoryController extends BaseController {
    static String PREFIX = "laboratory/";
    static String HEADER = "实验室管理";
    static String REDIRECT = "redirect:/laboratory/list";
    @Resource
    LaboratoryService laboratoryService;

    @GetMapping("/")
    public String index() {
        return REDIRECT;
    }

    @GetMapping("/list")
    @ApiOperation(value = "list Laboratory", notes = "list Laboratory")
    public String list(Model model) {
        Page<Laboratory> laboratorys = laboratoryService.getPageList();
        model.addAttribute("page", laboratorys);
        model.addAttribute("header", HEADER);
        return PREFIX + "laboratoryList";
    }

    @PostMapping("/list")
    @ApiOperation(value = "list Laboratory", notes = "list Laboratory")
    public String list(Model model, LaboratoryVo vo) {
        Page<Laboratory> laboratorys = laboratoryService.getPageList(vo);
        model.addAttribute("page", laboratorys);
        return PREFIX + "laboratoryList::table_list";
    }

    @GetMapping("/toAdd")
    @ApiOperation(value = "Laboratory add", notes = "Laboratory add")
    public String add(Model model) {
        model.addAttribute("header", HEADER);
        return PREFIX + "laboratoryAdd";
    }

    @PostMapping("/add")
    @ApiOperation(value = "add Laboratory", notes = "add Laboratory")
    public String add(Laboratory laboratory) {
        laboratoryService.save(laboratory);
        return REDIRECT;
    }

    @GetMapping("/toEdit")
    @ApiOperation(value = "Laboratory edit", notes = "Laboratory edit")
    public String toEdit(Model model, long id) {
        Laboratory laboratory = laboratoryService.getOne(id);
        model.addAttribute("laboratory", laboratory);
        model.addAttribute("header", HEADER);
        return PREFIX + "laboratoryEdit";
    }

    @PostMapping("/edit")
    @ApiOperation(value = "edit Laboratory", notes = "edit Laboratory")
    public String edit(Laboratory laboratory, BindingResult result) {
        laboratoryService.edit(laboratory);
        return REDIRECT;
    }

    @GetMapping("/toDetail")
    @ApiOperation(value = "Laboratory Detail", notes = "Laboratory Detail")
    public String toDetail(Model model, long id) {
        Laboratory laboratory = laboratoryService.getOne(id);
        model.addAttribute("laboratory", laboratory);
        model.addAttribute("header", HEADER);
        return PREFIX + "laboratoryDetail";
    }

    @GetMapping("/delete")
    @ApiOperation(value = "delete Laboratory", notes = "delete Laboratory")
    public String delete(long id) {
        laboratoryService.delete(id);
        return REDIRECT;
    }

    @GetMapping("/toImport")
    @ApiOperation(value = "Laboratory import", notes = "Laboratory import")
    public String toImport(Model model) {
        model.addAttribute("header", HEADER);
        return PREFIX + "laboratoryImport";
    }

    @PostMapping("/importLaboratory")
    @ApiOperation(value = "add Laboratory", notes = "add Laboratory")
    public String importLaboratory(MultipartFile file) {
        laboratoryService.importLaboratory(file);
        return REDIRECT;
    }
}
