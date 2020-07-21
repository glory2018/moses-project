/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.web;

import com.moses.demo.model.User;
import com.moses.demo.service.UserService;
import com.moses.framework.common.base.BaseController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * @author Moses
 * @date 2020/5/20
 */
@Api("file api")
@Controller
@RequestMapping(value = "/file")
public class FileController extends BaseController {
    @Autowired
    UserService userService;
    @Value("${file.upload-folder}")
    private String uploadFolder;
    private final ResourceLoader resourceLoader;

    @Autowired
    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * @param file 要上传的文件
     * @return
     */
    @GetMapping("/upload")
    public String upload(@RequestParam("fileName") MultipartFile file, @RequestParam("chineseName") String chineseName, HttpSession session) {
//        FileUtils.upload(file, uploadFolder + file.getOriginalFilename());
        User user = (User) session.getAttribute("USER");
//        user.setChineseName(chineseName);
//        user.setPhoto("/show?fileName=" + file.getOriginalFilename());
        userService.save(user);
        return "redirect:my/index";
    }

    /**
     * 显示单张图片
     *
     * @return
     */
    @RequestMapping("show")
    public ResponseEntity show(String fileName) {
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + uploadFolder + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
