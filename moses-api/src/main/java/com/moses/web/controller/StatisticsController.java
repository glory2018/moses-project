/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.controller;

import com.moses.framework.common.base.BaseController;
import com.moses.web.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Moses
 * @date 2020/6/20
 */
@Api("Statistics API")
@Controller
@RequestMapping(value = "/statistics")
public class StatisticsController extends BaseController {
    static String PREFIX = "statistics/";
    static String REDIRECT = "redirect:/statistics/list";
    @Resource
    StatisticsService statisticsService;

    @GetMapping("/")
    public String index() {
        return REDIRECT;
    }

    @GetMapping("/list")
    @ApiOperation(value = "list Statistics", notes = "list Statistics")
    public String list(Model model) {
        model.addAttribute("header", "统计图表");
        return PREFIX + "statisticsList";
    }

    @ResponseBody
    @GetMapping("/laboratoryNum")
    @ApiOperation(value = "laboratory Num", notes = "laboratory Num Statistics")
    public List laboratoryNum() {
        return statisticsService.laboratoryNum();
    }

    @ResponseBody
    @GetMapping("/yearNum")
    @ApiOperation(value = "quantity Change", notes = "quantity Change Statistics")
    public List yearNum() {
        return statisticsService.yearNum();
    }

    @GetMapping("/continued")
    public String index(Model model) {
        model.addAttribute("header", "连数统计");
        return "statistics/statisticsContinued";
    }

    @PostMapping("/continued")
    @ApiOperation(value = "calculation", notes = "calculation")
    public String continued(Model model, MultipartFile file, String group, String data) {
        Map map = statisticsService.continued(file, group, data);
        model.addAttribute("map", map);
        model.addAttribute("header", "连数统计");
        return "statistics/statisticsContinued";
    }

    @GetMapping("/pair")
    public String pair(Model model) {
        model.addAttribute("header", "对数统计");
        return "statistics/statisticsPair";
    }

    @PostMapping("/pair")
    @ResponseBody
    @ApiOperation(value = "pair", notes = "pair")
    public String pair(String data) {
        return statisticsService.pair(data);
    }
}
