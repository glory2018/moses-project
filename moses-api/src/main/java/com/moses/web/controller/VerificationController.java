/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.controller;

import com.moses.framework.common.base.BaseController;
import com.moses.framework.util.ValidateCodeUtil;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Moses
 * @date 2020/6/20
 */
@Api("Verification Code api")
@Controller
public class VerificationController extends BaseController {
    /**
     * 生成验证码
     */
    @GetMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            //设置相应类型,告诉浏览器输出的内容为图片
            response.setContentType("image/jpeg");
            //设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            ValidateCodeUtil randomValidateCode = new ValidateCodeUtil();
            //输出验证码图片方法
            randomValidateCode.getRandcode(request, response);
        } catch (Exception e) {
            logger.error("获取验证码失败>>>> ", e);
        }
    }

    /**
     * 校验验证码
     *
     * @param code
     * @param session
     * @return
     */
    @ResponseBody
    @GetMapping("/verificationCode")
    public boolean verificationCode(String code, HttpSession session) {
        try {
            String random = (String) session.getAttribute(ValidateCodeUtil.RANDOMCODEKEY);
            return random.equals(code);
        } catch (Exception e) {
            logger.error("验证码校验失败", e);
            return false;
        }
    }
}
