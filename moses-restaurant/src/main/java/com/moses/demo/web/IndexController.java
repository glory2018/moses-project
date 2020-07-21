package com.moses.demo.web;

import com.moses.demo.model.User;
import com.moses.demo.service.UserService;
import com.moses.framework.common.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Moses
 */
@ApiIgnore
@Controller
public class IndexController extends BaseController {
    static String PREFIX = "index/";
    @Resource
    UserService userService;

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(Model model) {
        return PREFIX + "main";
    }

    /**
     * 注册
     *
     * @return
     */
    @GetMapping("/register")
    public String register() {
        return PREFIX + "register";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.save(user);
        return PREFIX + "login";
    }

    /**
     * 退出
     *
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return PREFIX + "login";
    }

    /**
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return PREFIX + "login";
    }

    /**
     * 登录
     *
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String login(HttpSession session, User user) {
        User u = userService.findUser(user);
        if (null == u) {
            return PREFIX + "login";
        } else {
            session.setAttribute("USER", user);
            return "redirect:/";
        }
    }
}
