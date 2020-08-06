package com.moses.web.controller;

import com.moses.framework.common.base.BaseController;
import com.moses.framework.starter.service.MosesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Moses
 */
@ApiIgnore
@Controller
public class MosesController extends BaseController {
    @Autowired
    private MosesService mosesService;

    @ResponseBody
    @GetMapping("/welcome")
    public String welcome() {
        return mosesService.welcome();
    }
}
