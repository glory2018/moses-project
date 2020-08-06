/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.controller;

import com.moses.framework.common.base.BaseController;
import com.moses.web.model.Instrument;
import com.moses.web.model.Laboratory;
import com.moses.web.model.User;
import com.moses.web.service.InstrumentService;
import com.moses.web.service.LaboratoryService;
import com.moses.web.service.UserService;
import com.moses.web.vo.InstrumentVo;
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
import java.util.List;

/**
 * @author Moses
 * @date 2020/6/20
 */
@Api("Instrument API")
@Controller
@RequestMapping(value = "/instrument")
public class InstrumentController extends BaseController {
    static String PREFIX = "instrument/";
    static String HEADER = "仪器管理";
    static String REDIRECT = "redirect:/instrument/list";
    @Resource
    InstrumentService instrumentService;
    @Resource
    LaboratoryService laboratoryService;
    @Resource
    UserService userService;

    @GetMapping("/")
    public String index() {
        return REDIRECT;
    }

    @GetMapping("/list")
    @ApiOperation(value = "list Instrument", notes = "list Instrument")
    public String list(Model model) {
        Page<Instrument> instruments = instrumentService.getPageList();
        model.addAttribute("page", instruments);
        model.addAttribute("header", HEADER);
        return PREFIX + "instrumentList";
    }

    @PostMapping("/list")
    @ApiOperation(value = "list Instrument", notes = "list Instrument")
    public String list(Model model, InstrumentVo vo) {
        Page<Instrument> instruments = instrumentService.getPageList(vo);
        model.addAttribute("page", instruments);
        return PREFIX + "instrumentList::table_list";
    }

    @GetMapping("/toAdd")
    @ApiOperation(value = "Instrument add", notes = "Instrument add")
    public String add(Model model) {
        List<Laboratory> laboratorys = laboratoryService.getList();
        List<User> users = userService.getList();
        model.addAttribute("laboratorys", laboratorys);
        model.addAttribute("users", users);
        model.addAttribute("header", HEADER);
        return PREFIX + "instrumentAdd";
    }

    @PostMapping("/add")
    @ApiOperation(value = "add Instrument", notes = "add Instrument")
    public String add(Model model, MultipartFile[] files, Instrument instrument) {
        try {
            instrumentService.add(files, instrument);
        } catch (Exception exception) {
            model.addAttribute("msg", "仪器编号重复!");
            return "error/404";
        }
        return REDIRECT;
    }

    @GetMapping("/toEdit")
    @ApiOperation(value = "Instrument edit", notes = "Instrument edit")
    public String toEdit(Model model, long id) {
        Instrument instrument = instrumentService.getOne(id);
        List<Laboratory> laboratorys = laboratoryService.getList();
        List<User> users = userService.getList();
        model.addAttribute("laboratorys", laboratorys);
        model.addAttribute("users", users);
        model.addAttribute("instrument", instrument);
        model.addAttribute("header", HEADER);
        return PREFIX + "instrumentEdit";
    }

    @PostMapping("/edit")
    @ApiOperation(value = "edit Instrument", notes = "edit Instrument")
    public String edit(MultipartFile[] files, Instrument instrument) {
        instrumentService.edit(files, instrument);
        return REDIRECT;
    }

    @GetMapping("/toDetail")
    @ApiOperation(value = "Instrument Detail", notes = "Instrument Detail")
    public String toDetail(Model model, long id) {
        Instrument instrument = instrumentService.getOne(id);
        model.addAttribute("instrument", instrument);
        model.addAttribute("header", HEADER);
        return PREFIX + "instrumentDetail";
    }

    @GetMapping("/delete")
    @ApiOperation(value = "delete Instrument", notes = "delete Instrument")
    public String delete(long id) {
        instrumentService.delete(id);
        return REDIRECT;
    }

    @GetMapping("/toImport")
    @ApiOperation(value = "Instrument import", notes = "Instrument import")
    public String toImport(Model model) {
        model.addAttribute("header", HEADER);
        return PREFIX + "instrumentImport";
    }

    @PostMapping("/importInstrument")
    @ApiOperation(value = "add Instrument", notes = "add Instrument")
    public String importInstrument(MultipartFile file) {
        instrumentService.importInstrument(file);
        return REDIRECT;
    }
}
